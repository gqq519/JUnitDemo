package com.feicuiedu.junitdemo.bombapi;

import com.feicuiedu.junitdemo.bombapi.entity.NewsEntity;
import com.feicuiedu.junitdemo.bombapi.result.QueryResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 新闻的相关接口
 */

public interface NewsApi {

    //获取新闻列表,排序方式，接时间新到旧排序
    @GET("1/classes/News?order=-createdAt")
    Call<QueryResult<NewsEntity>> getVideoNewsList(@Query("limit") int limit, @Query("skip") int skip);

}
