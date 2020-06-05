package com.duzzi.xtest.test;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.duzzi.xtest.api.BaseObserver;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


/**
 * 文件名: TestUtils
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */
public class TestUtils implements LifecycleObserver {
    private static final String TAG = TestUtils.class.getSimpleName();
    private TestViewModel mTestViewModel;
    private Disposable mDisposable;

    public TestUtils(TestViewModel testViewModel) {
        this.mTestViewModel = testViewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.i(TAG, "onResume: " + mTestViewModel.getCount().getValue());
        if (mDisposable == null) {
            Observable.interval(1, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Long>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            mDisposable = d;
                        }

                        @Override
                        public void onNext(Long aLong) {
                            Log.d(TAG, "onNext: " + aLong);
                            mTestViewModel.getCount().setValue(mTestViewModel.getCount().getValue() + 1);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "run: " + mTestViewModel.getCount().getValue());
        }
    };

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.i(TAG, "onPause: " + mTestViewModel.getCount().getValue());

        if (mDisposable != null) {
            mDisposable.dispose();
            mDisposable = null;
        }
    }
}
