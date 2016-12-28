package com.feicuiedu.junitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextTestActivity extends AppCompatActivity {

    @BindView(R.id.tvShow)
    TextView mTvShow;
    @BindView(R.id.etInput)
    EditText mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnShow)
    public void onClick() {

        mTvShow.setText("Hello, "+mEtInput.getText().toString()+"!");

    }
}
