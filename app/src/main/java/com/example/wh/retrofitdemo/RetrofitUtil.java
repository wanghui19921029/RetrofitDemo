package com.example.wh.retrofitdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    //带有参数的get请求
    public void getTest(String version, String versionName, String model, String ui, String hwVersion, String mac, String region, String userpreferlanguage, String sso_tk, String _ak, String _time, String _sign, Callback<TestBean> callback) {
        API api = Network.getInstance().getTestApi();
        Call<TestBean> news = api.getTest(version, versionName, model, ui, hwVersion, mac, region, userpreferlanguage, sso_tk, _ak, _time, _sign);
        news.enqueue(callback);
    }

    //没有参数的get请求
    public void getBmp(Callback<ResponseBody> callback) {
        API api = Network.getInstance().getBmpApi();
        Call<ResponseBody> news = api.getBmp();
        news.enqueue(callback);
    }

    //rxjava
    public void getWeather(Observer<WeatherBean> observer) {
        API api = Network.getInstance().getWeatherApi();
        Observable<WeatherBean> observable = api.getWeather();
        subscribe(observable, observer);
    }

    private static <T> void subscribe(Observable<T> observable, Observer<T> netCallback) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(netCallback);
    }
}
