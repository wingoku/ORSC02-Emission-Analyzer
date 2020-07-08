package com.wingoku.carbonEmissionCalculator.interfaces;

import com.wingoku.carbonEmissionCalculator.models.RequestBody;
import com.wingoku.carbonEmissionCalculator.models.responses.directions.DirectionsResponse;
import com.wingoku.carbonEmissionCalculator.models.responses.searchCity.SearchCityResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by Umer on 7/7/2020.
 */

//retrofit network api's interface
public interface GeolocationAPI {
    @Headers({
            "Content-Type: application/json",
            "Accept: */*"
    })
    @POST("v2/directions/{profile}")
    Call<DirectionsResponse> getTimeAndDistance(@Header("Authorization") String apiKey, @Path("profile") String profile, @Body RequestBody body);

    @GET("geocode/search")
    Call<SearchCityResponse> searchCity(@Query("api_key") String apiKey, @Query("text") String city, @Query("layers") String layers);
}
