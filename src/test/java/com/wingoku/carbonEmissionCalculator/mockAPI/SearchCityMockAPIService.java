package com.wingoku.carbonEmissionCalculator.mockAPI;

import java.util.ArrayList;

import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import com.wingoku.carbonEmissionCalculator.models.RequestBody;
import com.wingoku.carbonEmissionCalculator.models.responses.directions.DirectionsResponse;
import com.wingoku.carbonEmissionCalculator.models.responses.searchCity.SearchCityResponse;
import com.wingoku.carbonEmissionCalculator.utils.TestingConstants;
import com.wingoku.carbonEmissionCalculator.utils.Utils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;

/**
 * @author rebeccafranks
 * @since 15/10/24.
 */
public class SearchCityMockAPIService implements GeolocationAPI {

    private final BehaviorDelegate<GeolocationAPI> delegate;

    public SearchCityMockAPIService(BehaviorDelegate<GeolocationAPI> service) {
        this.delegate = service;
    }

    @Override
    public Call<DirectionsResponse> getTimeAndDistance(String apiKey, String profile, RequestBody body) {

        DirectionsResponse directionsResponse = Utils.getGson().fromJson(TestingConstants.TIME_DISTANCE_MOCK_JSON, DirectionsResponse.class);
        return delegate.returningResponse(directionsResponse).getTimeAndDistance("", "", new RequestBody());
    }

    @Override
    public Call<SearchCityResponse> searchCity(String apiKey, String city, String layers) {

        SearchCityResponse searchCityResponse = Utils.getGson().fromJson(TestingConstants.SEARCH_CITY_MOCK_JSON, SearchCityResponse.class);
        return delegate.returningResponse(searchCityResponse).searchCity("", "", "");
    }
}