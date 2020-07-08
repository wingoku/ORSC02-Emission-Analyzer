package com.wingoku.carbonEmissionCalculator;

import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import com.wingoku.carbonEmissionCalculator.models.responses.RequestBody;
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

    public void calculate() {
        c02Map = Utils.getGson().fromJson(Constants.c02DataJSON, HashMap.class);

        List<List<Double>> coordinatesList = getCitiesCoordinates(new String[]{commandLineArgsMap.get(KEY_START_CITY), commandLineArgsMap.get(KEY_END_CITY)}).blockingGet();

        if(coordinatesList.size() >= 2) {
            RequestBody requestBody = new RequestBody();
            requestBody.setCoordinates(coordinatesList);
            requestBody.setUnit(KILOMETER);

            getC02Consumption(requestBody, Constants.CAR_PROFILE, commandLineArgsMap.get(KEY_TRANSPORTATION_TYPE));
        }
    }

    private Single<List<List<Double>>> getCitiesCoordinates(String[] cities) {
        return Observable.fromIterable(Arrays.asList(geolocationAPI.searchCity(Constants.ORS_TOKEN, cities[0], Constants.LOCALITY), geolocationAPI.searchCity(Constants.ORS_TOKEN, cities[1], Constants.LOCALITY)))
                .flatMap(new Function<Observable<SearchCityResponse>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<SearchCityResponse> apply(Observable<SearchCityResponse> searchCityResponseObservable) throws Exception {
                        return searchCityResponseObservable.observeOn(Schedulers.computation());
                    }
                })
                .toList()
                .map(new Function<List<Object>, List<List<Double>>>() {
                    @Override
                    public List<List<Double>> apply(List<Object> objects) throws Exception {
                        SearchCityResponse city1 = (SearchCityResponse) objects.get(0);
                        SearchCityResponse city2 = (SearchCityResponse) objects.get(1);

                        List<List<Double>> coords = new ArrayList<>();
                        coords.add(city1.getFeatures().get(0).getGeometry().getCoordinates());
                        coords.add(city2.getFeatures().get(0).getGeometry().getCoordinates());
                        return coords;
                    }
                })
                .onErrorReturn(new Function<Throwable, List<List<Double>>>() {
                    @Override
                    public List<List<Double>> apply(Throwable throwable) throws Exception {
                        logger.error("Data not found. One of the city name is invalid");
                        return new ArrayList<>();
                    }
                });
    }

    private void getC02Consumption(RequestBody requestBody, String profile, String transportationType) {
        DirectionsResponse directionsResponse = geolocationAPI.getTimeAndDistance(Constants.ORS_TOKEN, profile, requestBody).blockingSingle();
        double carbonExpenditure = directionsResponse.getRoutes().get(0).getSummary().getDistance() * (c02Map.get(transportationType)/1000.0);
        logger.info("Trip from {} to {} with car type {}", commandLineArgsMap.get(KEY_START_CITY), commandLineArgsMap.get(KEY_END_CITY), commandLineArgsMap.get(KEY_TRANSPORTATION_TYPE));
        logger.info("Your trip caused {} of C02-equivalent", carbonExpenditure);
    }
}
