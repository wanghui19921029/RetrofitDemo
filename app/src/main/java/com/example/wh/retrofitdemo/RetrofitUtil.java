package com.example.wh.retrofitdemo;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static final String TAG = "whwhwh---RetrofitUtil";
    // 双重检索
    private static volatile RetrofitUtil mInstance;

    private RetrofitUtil() {
    }

    public static RetrofitUtil getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtil();
                }
            }
        }
        return mInstance;
    }

    //没有参数的get请求
    public void getBmp(Callback<ResponseBody> callback) {
        API api = getBmpApi();
        Call<ResponseBody> news = api.getBmp("http://i0.img.cp21.ott.cibntv.net/lc02_gugwl/201902/22/15/41/jiaorouji.jpg");
        news.enqueue(callback);
    }

    //rxjava
    public void getWeather(Observer<WeatherBean> observer) {
        API api = getWeatherApi();
        Observable<WeatherBean> observable = api.getWeather();
        subscribe(observable, observer);
    }

    private static <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public API getTestApi() {
        Retrofit retrofit = new Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://xfeedback-scloud.cp21.ott.cibntv.net")
                .build();
        return retrofit.create(API.class);
    }

    public API getWeatherApi() {
        Retrofit retrofit = new Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                //使用rxjava的adapter
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://t.weather.sojson.com")
                .build();
        return retrofit.create(API.class);
    }

    public API getTApi() {
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        HttpUrl.Builder builder = chain.request().url().newBuilder();
                        HttpUrl httpUrl = builder.build();
                        Log.i(TAG, "getBmpApi: url = " + httpUrl.toString());
                        Request request = chain.request().newBuilder().url(httpUrl).build();
                        Response response = chain.proceed(request);
                        return response;
                    }
                })
                .connectTimeout(5 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                //使用rxjava的adapter
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://sdkcar.iqiyi.com")
                .client(okHttpClient)
                .build();
        return retrofit.create(API.class);
    }

    public API getBmpApi() {
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        HttpUrl.Builder builder = chain.request().url().newBuilder();
                        HttpUrl httpUrl = builder.build();
                        Log.i(TAG, "getBmpApi: url = " + httpUrl.toString());
                        Request request = chain.request().newBuilder().url(httpUrl).build();
                        Response response = chain.proceed(request);
                        return response;
                    }
                })
                .connectTimeout(5 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://i0.img.cp21.ott.cibntv.net/")
                .build();
        return retrofit.create(API.class);
    }
}
