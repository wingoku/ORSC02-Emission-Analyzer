package com.wingoku.carbonEmissionCalculator;

import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import com.wingoku.carbonEmissionCalculator.mockAPI.SearchCityMockAPIService;
import com.wingoku.carbonEmissionCalculator.models.RequestBody;
import com.wingoku.carbonEmissionCalculator.models.responses.directions.DirectionsResponse;
import com.wingoku.carbonEmissionCalculator.models.responses.searchCity.SearchCityResponse;
import com.wingoku.carbonEmissionCalculator.utils.TestingConstants;
import com.wingoku.carbonEmissionCalculator.utils.Utils;
import okhttp3.Request;
import okio.Timeout;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.wingoku.carbonEmissionCalculator.utils.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarbonEmissionCalculatorTest {
    @Mock
    GeolocationAPI geolocationAPI;
    @Mock
    Logger logger;
    @Mock
    RequestBody requestBody;

    private final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://example.com").build();

    private CarbonEmissionCalculator carbonEmissionCalculator;
    private List<List<Double>> coordinatesList;
    MockRetrofit mockRetrofit;

    @Before
    public void setup() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_START_CITY, "Aachen");
        map.put(KEY_END_CITY, "Cologne");
        map.put(KEY_TRANSPORTATION_TYPE, "large-electric-car");

        mockRetrofit = new MockRetrofit.Builder(retrofit).build();

        coordinatesList = Arrays.asList(Arrays.asList(1.0, 1.0), Arrays.asList(1.0, 1.0));

        carbonEmissionCalculator = new CarbonEmissionCalculator(map, logger, geolocationAPI);
    }

    public void mockSearchCityResponse() {
        SearchCityResponse searchCityResponse = Utils.getGson().fromJson(TestingConstants.SEARCH_CITY_MOCK_JSON, SearchCityResponse.class);
    }

    public void mockTimeDistanceResponse() {
        DirectionsResponse directionsResponse = Utils.getGson().fromJson(TestingConstants.TIME_DISTANCE_MOCK_JSON, DirectionsResponse.class);
    }

    @Test
    public void testCalculate() throws IOException {
        BehaviorDelegate<GeolocationAPI> delegate = mockRetrofit.create(GeolocationAPI.class);
        SearchCityMockAPIService mockAPIService = new SearchCityMockAPIService(delegate);
        Call<SearchCityResponse> searchCityResponseCall = mockAPIService.searchCity("", "", "");

        when(geolocationAPI.searchCity("", "", ""))
                .thenReturn(searchCityResponseCall);
        assertEquals(true, carbonEmissionCalculator.calculate());
        verify(geolocationAPI).searchCity("mockAPIKey", "mockCity", "mockLayer");
        verify(geolocationAPI).getTimeAndDistance("mockAPIKey", "mockProfile", requestBody);
    }
}
