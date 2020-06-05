package com.duzzi.xtest.viewmodel;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.duzzi.xtest.api.BaseObserver;
import com.duzzi.xtest.api.RequestManager;
import com.duzzi.xtest.bean.ArticlesBean;
import com.duzzi.xtest.bean.BaseRsp;

import java.util.Date;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 文件名: HomeViewModle
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */
public class HomeViewModel extends ViewModel {

    public LiveData<ArticlesBean> getLiveData() {
        return mLiveData;
    }

    private MutableLiveData<String> mReqLiveData = new MutableLiveData<>();
    private static final String TAG = HomeViewModel.class.getSimpleName();

    private LiveData<ArticlesBean> mLiveData = Transformations.switchMap(mReqLiveData, new Function<String, LiveData<ArticlesBean>>() {
        @Override
        public LiveData<ArticlesBean> apply(String input) {
            Log.d(TAG, "apply: " + input);
            return requestData();
        }
    });

    public void refresh() {
        mReqLiveData.setValue("banner " + new Date(System.currentTimeMillis()).toString());
    }


    private LiveData<ArticlesBean> requestData() {
        MutableLiveData<ArticlesBean> articlesBeanMutableLiveData = new MutableLiveData<>();
        RequestManager.getInstance().getArticles().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseObserver<BaseRsp<ArticlesBean>>() {

            @Override
            public void onNext(BaseRsp<ArticlesBean> articlesBeanBaseRsp) {
                Log.d(TAG, "onNext: " + articlesBeanBaseRsp.getData());
                articlesBeanMutableLiveData.setValue(articlesBeanBaseRsp.getData());
            }

            @Override
            public void onError(Throwable e) {
                articlesBeanMutableLiveData.setValue(null);
            }
        });
        return articlesBeanMutableLiveData;

    }
}
