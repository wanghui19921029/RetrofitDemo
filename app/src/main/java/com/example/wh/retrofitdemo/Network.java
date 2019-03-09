package com.example.wh.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
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
                .baseUrl("http://t.weather.sojson.com")
                .build();
        return retrofit.create(API.class);
    }

    public API getBmpApi() {
        Retrofit retrofit = new Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .baseUrl("http://i1.img.cp21.ott.cibntv.net/")
                .build();
        return retrofit.create(API.class);
    }
}