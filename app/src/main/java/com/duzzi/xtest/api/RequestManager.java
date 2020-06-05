package com.duzzi.xtest.api;

import com.duzzi.xtest.bean.ArticlesBean;
import com.duzzi.xtest.bean.BannerBean;
import com.duzzi.xtest.bean.BaseRsp;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 文件名: RequestManager
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */
public class RequestManager {
    private static RequestManager sRequestManager = null;
    private final ApiService mApiService;

    public static RequestManager getInstance() {
        if (sRequestManager == null) {
            sRequestManager = new RequestManager();
        }
        return sRequestManager;
    }

    private RequestManager() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiService = retrofit.create(ApiService.class);
    }

    public Observable<BaseRsp<List<BannerBean>>> getBanners() {
        return mApiService.getBanners();
    }

    public Observable<BaseRsp<ArticlesBean>> getArticles() {
        return mApiService.getArticles();
    }
}
