package com.example.wh.retrofitdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface API {

    //get请求 @Query添加参数
    @GET("api/v3/Tvfeedback")
    Call<TestBean> getTest(@Query("version") String version, @Query("versionName") String versionName,
                           @Query("model") String model, @Query("ui") String ui,
                           @Query("hwVersion") String hwVersion, @Query("mac") String mac,
                           @Query("region") String region, @Query("user-prefer-language") String userpreferlanguage,
                           @Query("sso_tk") String sso_tk, @Query("_ak") String _ak,
                           @Query("_time") String _time, @Query("_sign") String _sign);


    @GET("api/weather/city/101030100")
    Call<WeatherBean> getWeather();


    @GET("lc03_gugwl/201901/11/19/40/screenprotect1.png")
    Call<ResponseBody> getBmp();
}