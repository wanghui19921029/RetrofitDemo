package com.example.wh.retrofitdemo;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static final String TAG = "whwhwh---Network";
    // 双重检索
    private static volatile Network mInstance;

    private Network() {
    }

    public static Network getInstance() {
        if (mInstance == null) {
            synchronized (Network.class) {
                if (mInstance == null) {
                    mInstance = new Network();
                }
            }
        }
        return mInstance;
    }

    public API getTestApi() {
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        HttpUrl.Builder builder = chain.request().url().newBuilder();
                        HttpUrl httpUrl = builder.build();
                        Log.i(TAG, "intercept: url = " + httpUrl.toString());
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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://t.weather.sojson.com")
                .build();
        return retrofit.create(API.class);
    }

    public API getBmpApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://i1.img.cp21.ott.cibntv.net/")
                .build();
        return retrofit.create(API.class);
    }
}