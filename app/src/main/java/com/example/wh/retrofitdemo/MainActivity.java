package com.example.wh.retrofitdemo;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "whwhwh---MainActivity";
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv = findViewById(R.id.iv);
        getTest("V2501RCN02C080337D03041D", "8.0.337D_0304", "X440N", "8.0", "null", "b01bd205a51b", "CN", "zh-cn", "103XXXpOE6Jy8HNZkgyO1LBusBuSgm1PKt5fPm1MtW9SWZg7CIFHhKjw1BAbN55e5KjCO9w4sZLkm5P3Rm3KWm3gc5WG1hhDtlp9tKUMdBsWWfyELRR0iwm4", "akfileup_YHoqMHgt", "1552115200711", "09688d85db2ab6042796288ec83b9783");
        getWeather();
        getBmp();
    }

    private void getTest(String version, String versionName, String model, String ui, String hwVersion, String mac, String region, String userpreferlanguage, String sso_tk, String _ak, String _time, String _sign) {
        API api = Network.getInstance().getTestApi();
        Call<TestBean> news = api.getTest(version, versionName, model, ui, hwVersion, mac, region, userpreferlanguage, sso_tk, _ak, _time, _sign);
        news.enqueue(new Callback<TestBean>() {
            @Override
            public void onResponse(Call<TestBean> call, Response<TestBean> response) {
                TestBean body = response.body();
                Log.i(TAG, "onResponse: " + body.toString());
            }

            @Override
            public void onFailure(Call<TestBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void getWeather() {
        API api = Network.getInstance().getWeatherApi();
        Call<WeatherBean> news = api.getWeather();
        news.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                WeatherBean body = response.body();
                Log.i(TAG, "onResponse: " + body.toString());
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void getBmp() {
        API api = Network.getInstance().getBmpApi();
        Call<ResponseBody> news = api.getBmp();
        news.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                mIv.setImageBitmap(BitmapFactory.decodeStream(response.body().byteStream()));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
