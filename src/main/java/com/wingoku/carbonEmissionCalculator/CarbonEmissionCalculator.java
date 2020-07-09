package com.wingoku.carbonEmissionCalculator;

import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import com.wingoku.carbonEmissionCalculator.models.RequestBody;
import com.wingoku.carbonEmissionCalculator.models.responses.directions.DirectionsResponse;
import com.wingoku.carbonEmissionCalculator.models.responses.searchCity.SearchCityResponse;
import com.wingoku.carbonEmissionCalculator.utils.Constants;
import com.wingoku.carbonEmissionCalculator.utils.Utils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.wingoku.carbonEmissionCalculator.utils.Constants.*;

/**
 * Created by Umer on 7/7/2020.
 */

public class CarbonEmissionCalculator {
    private GeolocationAPI geolocationAPI;
    private Logger logger;
    private HashMap<String, String> commandLineArgsMap;
    private HashMap<String, Double> c02Map;

    public CarbonEmissionCalculator(HashMap<String, String> commandLineArgsMap, Logger logger, GeolocationAPI geolocationAPI) {
        this.commandLineArgsMap = commandLineArgsMap;
        this.logger = logger;
        this.geolocationAPI = geolocationAPI;
    }

    /**
     * Start calculating the C02 emission.
     * @return true: if C02 emission was calculated successful
     *         false: otherwise
     */
    public boolean calculate() {
        c02Map = Utils.getGson().fromJson(Constants.c02DataJSON, HashMap.class);

        List<List<Double>> coordinatesList = getCitiesCoordinates(new String[]{commandLineArgsMap.get(KEY_START_CITY), commandLineArgsMap.get(KEY_END_CITY)}).blockingGet();

        //openRouteService must return coordinates for 2 cities since we're passing 2 cities. Otherwise there's a user error or server didn't behave as expected
        if(coordinatesList.size() == 2) {
            RequestBody requestBody = new RequestBody();
            requestBody.setCoordinates(coordinatesList);
            requestBody.setUnit(KILOMETER);

            return getC02Consumption(requestBody, Constants.CAR_PROFILE, commandLineArgsMap.get(KEY_TRANSPORTATION_TYPE));
        }
        return false;
    }

    private Single<List<List<Double>>> getCitiesCoordinates(String[] cities) {
        //combine observables to get responses in a unified method to convert them to list
         return Observable.fromIterable(Arrays.asList(geolocationAPI.searchCity(ORS_TOKEN, cities[0], LOCALITY), geolocationAPI.searchCity(ORS_TOKEN, cities[1], LOCALITY)))
                .subscribeOn(Schedulers.computation())
                .flatMap((Function<Call<SearchCityResponse>, ObservableSource<?>>) searchCityResponseCall -> {
                    Response response = searchCityResponseCall.execute();
                    if(response.isSuccessful()) {
                        return Observable.just((SearchCityResponse) response.body());
                    }
                    SearchCityResponse errorResponse = Utils.getGson().fromJson(response.errorBody().string(), SearchCityResponse.class);
                    logger.error("Server sent an error: "+ errorResponse.getError());
                    return Observable.just(errorResponse);
                })
                .toList()//added responses to list
                .map(objects -> {
                    SearchCityResponse city1 = (SearchCityResponse) objects.get(0);
                    SearchCityResponse city2 = (SearchCityResponse) objects.get(1);

                    List<List<Double>> coords = new ArrayList<>();
                    coords.add(city1.getFeatures().get(0).getGeometry().getCoordinates());
                    coords.add(city2.getFeatures().get(0).getGeometry().getCoordinates());
                    return coords;
                })
                .onErrorReturn(throwable -> {
                    logger.error("Something went wrong.");
                    return new ArrayList<>();
                });
    }

    private boolean getC02Consumption(RequestBody requestBody, String profile, String transportationType) {
        DirectionsResponse directionsResponse = (DirectionsResponse) Observable.just(geolocationAPI.getTimeAndDistance(Constants.ORS_TOKEN, profile, requestBody))
                .subscribeOn(Schedulers.computation())
                .flatMap((Function<Call<DirectionsResponse>, ObservableSource<?>>) directionsResponseCall -> {
                    Response response = directionsResponseCall.execute();
                    if(response.isSuccessful()) {
                        return Observable.just((DirectionsResponse) response.body());
                    }
                    DirectionsResponse errorResponse = Utils.getGson().fromJson(response.errorBody().string(), DirectionsResponse.class);
                    logger.error("Server sent an error: "+ errorResponse.getError());
                    return Observable.just(errorResponse);
                })
                .onErrorReturn(throwable -> {
                    logger.error("Distance not available for the provided cities & transportation mode");
                    DirectionsResponse errorResponse = new DirectionsResponse();
                    errorResponse.setError("Something went wrong");
                    return errorResponse;
                }).blockingSingle();

        if(directionsResponse == null || directionsResponse.getError() != null)
            return false;

        double carbonExpenditure = directionsResponse.getRoutes().get(0).getSummary().getDistance() * (c02Map.get(transportationType)/1000.0);
        logger.info("Trip from {} to {} with car type {}", commandLineArgsMap.get(KEY_START_CITY), commandLineArgsMap.get(KEY_END_CITY), commandLineArgsMap.get(KEY_TRANSPORTATION_TYPE));
        logger.info("Your trip caused {} of C02-equivalent", carbonExpenditure);
        return true;
    }
}
