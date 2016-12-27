package com.feicuiedu.junitdemo.bombapi;


import com.feicuiedu.junitdemo.bombapi.entity.UserEntity;
import com.feicuiedu.junitdemo.bombapi.result.UserResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 用户相关网络接口
 */

public interface UserApi {

    //用户注册
    @POST("1/users")
    Call<UserResult> register(@Body UserEntity userEntity);

    //用户登录
    @GET("1/login")
    Call<UserResult> login(@Query("username") String username, @Query("password") String password);

}
