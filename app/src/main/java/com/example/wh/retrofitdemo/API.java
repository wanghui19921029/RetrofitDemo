package com.example.wh.retrofitdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;


public interface API {

    // get请求 @Query添加参数
    @GET("api/v3/Tvfeedback")
    Call<TestBean> getTest(@Query("version") String version, @Query("versionName") String versionName,
                           @Query("model") String model, @Query("ui") String ui,
                           @Query("hwVersion") String hwVersion, @Query("mac") String mac,
                           @Query("region") String region, @Query("user-prefer-language") String userpreferlanguage,
                           @Query("sso_tk") String sso_tk, @Query("_ak") String _ak,
                           @Query("_time") String _time, @Query("_sign") String _sign);


    // 结合rxjava使用
    @GET("api/weather/city/101030100")
    Observable<WeatherBean> getWeather();

    // base url：Retrofit.baseUrl()
    // 端点url：@GET（url）
    // 动态url：@Url 后的
    //
    // 我们了解了base url和端点url的连接,那Retrofit又是如何处理base url和动态url的呢？
    // 分三种情况(base url为"https://api.weibo.com/2/")：
    //
    // 1.动态url包含完整的scheme和host,直接使用动态url作为最终的请求url
    // 例如动态url为"http://apis.baidu.com/apistore/weatherservice/weather"
    // 那么最终的请求url也为"http://apis.baidu.com/apistore/weatherservice/weather"
    // 2.动态url包含该host,则使用base url的scheme连接动态url作为最终的请求url
    // 例如动态url为"//apis.baidu.com/apistore/weatherservice/weather"
    // 那么最终的请求url为"https://apis.baidu.com/apistore/weatherservice/weather"
    // 3.动态url不包含scheme和host,则将base url与动态url连接起来作为最终的请求url
    // 这种方式与在@GET后定义端点url一致.
    // 例如动态url为"/apistore/weatherservice/weather"
    // 那么最终的请求url为"https://api.weibo.com/apistore/weatherservice/weather"
    @GET
    Call<ResponseBody> getBmp(@Url String url);
}