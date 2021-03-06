package com.example.wh.retrofitdemo;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface API {
    // 结合rxjava使用
    // base url：Retrofit.baseUrl()
    // 端点url：@GET（url）
    // 动态url：@Url 后的
    //
    // 首先，明确一个概念，如果base url中包含路径参数,则必须以"/"结尾.
    // 当端点(动态)url以"/"开头 代表绝对路径 后缀路径，在base url中包含的路径参数会被忽略.比如下面第三种
    //
    // 我们了解了base url和端点url的连接,那Retrofit又是如何处理base url和动态url的呢？
    // 分四种情况(base url为"https://api.weibo.com/2/")：其中"2/"称为路径参数.
    //
    // 下面第三种和第四种的区别在于动态url是否以"/"开头:
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
    // 4.动态url不包含scheme和host,则将base url与动态url连接起来作为最终的请求url
    // 这种方式与在@GET后定义端点url一致.
    // 例如动态url为"apistore/weatherservice/weather"
    // 那么最终的请求url为"https://api.weibo.com/2/apistore/weatherservice/weather"

    @GET("api/weather/city/101030100")
    Observable<WeatherBean> getWeather();

    @GET
    Call<ResponseBody> getBmp(@Url String url);

}