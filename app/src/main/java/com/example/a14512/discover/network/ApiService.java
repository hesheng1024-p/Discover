package com.example.a14512.discover.network;


import com.example.a14512.discover.modules.routeplan.mode.entity.Scenic;
import com.example.a14512.discover.modules.main.mode.entity.WeatherData;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author 14512 on 2017/8/15.
 */

public interface ApiService {

    String BASE_URL = "http://139.199.15.137:8080/faxianbeiwork/";
    String WEATHER = "https://free-api.heweather.com/s6/weather/";



    //---------------------user---------------------------------------------

    /**
     * 获取七牛云token
     * @return Result<String>
     * */
    @POST("getToken.php")
    Observable<Result<String>> getToken();

    /**
     * @param location
     * @param key
     * @return
     */
    @GET("now")
    Observable<WeatherData> getWeather(@Query("location") String location,
                                       @Query("key") String key);

    /**
     * 获取路线规划
     * @param startLng
     * @param startLat
     * @param endLng
     * @param endLat
     * @param startName
     * @param endName
     * @param seTime
     * @param personSelect
     * @param tfSelect
     * @param onePlace
     * @param phone
     * @return
     */
    @GET("LinePlanServlet")
    Observable<Result<ArrayList<Scenic>>> getScenic(@Query("startLng") double startLng,
                                                    @Query("startLat") double startLat,
                                                    @Query("endLng") double endLng,
                                                    @Query("endLat") double endLat,
                                                    @Query("startName") String startName,
                                                    @Query("endName") String endName,
                                                    @Query("startTime") String startTime,
                                                    @Query("seTime") long seTime,
                                                    @Query("personSelect") int personSelect,
                                                    @Query("tfSelect") int tfSelect,
                                                    @Query("onePlace") int onePlace,
                                                    @Query("userPhone") String phone);

    /**
     * 刷新某一个景点
     * @param changePlace
     * @param lastPlace
     * @param nextPlace
     * @param personSelect
     * @return
     */
    @GET("ChangePlaceServlet")
    Observable<Result<Scenic>> changeOneScenic(@Query("changePlace") String changePlace,
                                       @Query("lastPlace") String lastPlace,
                                       @Query("nextPlace") String nextPlace,
                                       @Query("personSelect") int personSelect);

    /**
     * 关注景点
     * @param isFollow
     * @param phone
     * @param placeName
     * @return
     */
    @GET("PlaceFollowServlet")
    Observable<Result<Integer>> followScenic(@Query("placeFollow") int isFollow,
                                    @Query("userPhone") String phone,
                                    @Query("placeName") String placeName);



}
