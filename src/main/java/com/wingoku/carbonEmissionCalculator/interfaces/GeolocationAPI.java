package com.wingoku.carbonEmissionCalculator.interfaces;

import com.wingoku.carbonEmissionCalculator.models.responses.RequestBody;
import com.wingoku.carbonEmissionCalculator.models.responses.directions.DirectionsResponse;
import com.wingoku.carbonEmissionCalculator.models.responses.searchCity.SearchCityResponse;
import io.reactivex.Observable;
import retrofit2.http.*;

/**
 * Created by Umer on 7/7/2020.
 */

public interface GeolocationAPI {
    @Headers({
            "Content-Type: application/json",
            "Accept: */*"
    })
    @POST("v2/directions/{profile}")
    Observable<DirectionsResponse> getTimeAndDistance(@Header("Authorization") String apiKey, @Path("profile") String profile, @Body RequestBody body);

    @GET("geocode/search")
    Observable<SearchCityResponse> searchCity(@Query("api_key") String apiKey, @Query("text") String city, @Query("layers") String layers);

    @Headers({
            "Content-Type: application/json",
            "Accept: */*"
    })
    @POST("/")
    Observable<String> test(@Header("Authorization") String apiKey, @Body RequestBody body);
}
