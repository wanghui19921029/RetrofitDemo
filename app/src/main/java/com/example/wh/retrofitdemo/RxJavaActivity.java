package com.example.wh.retrofitdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static java.lang.Thread.sleep;

public class RxJavaActivity extends AppCompatActivity {
    private static final String TAG = "RxJavaTag";
    private static final int[] drawableRes = new int[]{R.drawable.amap_bus, R.drawable.amap_car, R.drawable.amap_man, R.drawable.amap_ride};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn, R.id.btn2})
    protected void onClickView(View view) {
        switch (view.getId()) {
            case R.id.btn:
//                rxJavaBaseUse();
                timeDoSomething();
//                flow();
                break;
            case R.id.btn2:
                if (mSubscription != null) {
                    mSubscription.request(1);
                }
                break;
        }
    }

    //RxJava基本使用
    private void rxJavaBaseUse() {
        //被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        });
        //观察者
        Observer<String> observer = new Observer<String>() {
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(String value) {
                if ("连载2".equals(value)) {
                    mDisposable.dispose();
                }
                Log.i(TAG, "onNext = " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError = " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: asdf");
            }
        };
        //订阅
        observable.subscribeOn(Schedulers.io())//执行在io线程
                .observeOn(AndroidSchedulers.mainThread())//回调在主线程
                .subscribe(observer);
    }

    /**
     * subscribe:订阅
     * consumer:消费者
     * producer:生产者
     * Consumer是简易版的Observer,他有多重重载,可以自定义你需要处理的信息,我这里调用的是只接受onNext消息的方法,
     * 他只提供一个回调接口accept,由于没有onError和onCompete,无法再接受到onError或者onCompete之后,实现函数回调.
     * 无法回调,并不代表不接收,他还是会接收到onError和onCompete之后做出默认操作,也就是监听者（Consumer）不在接收
     * Observable发送的消息,下方的代码测试了该效果.
     */
    @SuppressLint("CheckResult")
    private void timeDoSomething() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(123);
                sleep(1000);
                emitter.onNext(456);
                sleep(1000);
                emitter.onNext(789);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i(TAG, "accept: value = " + integer);
                    }
                });
    }

    private Subscription mSubscription;

    private void flow() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.i(TAG, "发送事件 1");
                emitter.onNext(1);
                Log.i(TAG, "发送事件 2");
                emitter.onNext(2);
                Log.i(TAG, "发送事件 3");
                emitter.onNext(3);
                Log.i(TAG, "发送事件 4");
                emitter.onNext(4);
                Log.i(TAG, "发送完成");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.i(TAG, "onSubscribe");
                        mSubscription = s;
                        s.request(4);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG, "接收到了事件: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete");
                    }
                });
    }
}
