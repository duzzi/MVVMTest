package com.duzzi.xtest.api;

import com.duzzi.xtest.bean.ArticlesBean;
import com.duzzi.xtest.bean.BannerBean;
import com.duzzi.xtest.bean.BaseRsp;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 文件名: ApiService
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */
public interface ApiService {
    //https://www.wanandroid.com/article/list/1/json
    //@GET("users/{user}/repos")
    //  Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("banner/json")
    Observable<BaseRsp<List<BannerBean>>> getBanners();

    @GET("article/list/1/json")
    Observable<BaseRsp<ArticlesBean>> getArticles();

}
