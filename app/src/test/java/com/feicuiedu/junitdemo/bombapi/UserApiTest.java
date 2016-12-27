package com.feicuiedu.junitdemo.bombapi;

import com.feicuiedu.junitdemo.bombapi.entity.UserEntity;
import com.feicuiedu.junitdemo.bombapi.result.UserResult;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Created by gqq on 2016/12/27.
 */

// 测试接口构建有没有问题
public class UserApiTest {

    private UserApi mUserApi;

    @Before
    public void setUp() throws Exception {
        mUserApi = BombClient.getInstance().getUserApi();
    }

    @After
    public void tearDown() throws Exception {

    }

    // 测试注册方法的功能
    @Test
    public void register() throws Exception {
        UserEntity userEntity = new UserEntity("gqq","123456");
        Call<UserResult> userResultCall = mUserApi.register(userEntity);
        // 通过同步请求直接拿到数据：代码里面都是异步，为的就是不阻塞线程
        Response<UserResult> resultResponse = userResultCall.execute();
        UserResult userResult = resultResponse.body();
        assertNotNull(userResult);
        // 如果请求下来的实体类里面有类似于信息:code,message(登录成功、注册成功等)，可以通过assertEquals()
    }

    @Test
    public void login() throws Exception {
        Call<UserResult> resultCall = mUserApi.login("gqq01", "123456");
        Response<UserResult> execute = resultCall.execute();
        UserResult body = execute.body();
        assertNotNull(body);
    }
}