package com.feicuiedu.junitdemo;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.feicuiedu.junitdemo.bombapi.BombClient;
import com.feicuiedu.junitdemo.bombapi.UserApi;
import com.feicuiedu.junitdemo.bombapi.result.ErrorResult;
import com.feicuiedu.junitdemo.bombapi.result.UserResult;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etUsername)
    TextInputEditText mEtUsername;
    @BindView(R.id.etPassword)
    TextInputEditText mEtPassword;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onClick() {
        final String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        //用户名密码能不为空
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "用户名密码为空", Toast.LENGTH_SHORT).show();
            return;
        }

        //登录网络请求
        UserApi userApi = BombClient.getInstance().getUserApi();
        Call<UserResult> call = userApi.login(username, password);
        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                //隐藏进度条
                mBtnLogin.setVisibility(View.VISIBLE);
                //登录未成功
                if (!response.isSuccessful()) {
                    try {
                        String error = response.errorBody().string();
                        ErrorResult errorResult = new Gson().fromJson(error, ErrorResult.class);
                        Toast.makeText(MainActivity.this, errorResult.getError(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                //登录成功
                UserResult result = response.body();
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                //隐藏进度条
                mBtnLogin.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "请求失败"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
