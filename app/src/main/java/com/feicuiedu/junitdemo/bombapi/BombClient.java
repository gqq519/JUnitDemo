package com.feicuiedu.junitdemo.bombapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/12/21 0021.
 */

public class BombClient {
    private static BombClient bombClient;

    public static BombClient getInstance(){
        if (bombClient == null){
            bombClient = new BombClient();
        }
        return bombClient;
    }

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private UserApi userApi;
    private NewsApi newsApi;

    private BombClient(){
        //日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //构建OkHttp
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BombInterceptor())//添加Bomb必要的请求头的拦截器
                .addInterceptor(httpLoggingInterceptor)//添加日志拦截器
                .build();

        //让Gson能够将Bomb返回的时间戳自动转换为Date对象
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        //构建Retrofit
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                //bomb服务器的BaseUrl
                .baseUrl("https://api.bmob.cn/")
                //添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    //拿到UserApi
    public UserApi getUserApi(){
        if (userApi == null){
            userApi = retrofit.create(UserApi.class);
        }
        return userApi;
    }

    //拿到UserApi
    public NewsApi getNewsApi(){
        if (newsApi == null){
            newsApi = retrofit.create(NewsApi.class);
        }
        return newsApi;
    }
}
