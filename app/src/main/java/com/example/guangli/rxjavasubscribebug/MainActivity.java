package com.example.guangli.rxjavasubscribebug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 演示异步任务错误的取消方式导致crash
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void gotoWrongWay(){
        startActivity(new Intent(this, WrongWayActivity.class));
    }

    @OnClick(R.id.button2)
    void gotoRightWay(){
        startActivity(new Intent(this, RightWayActivity.class));
    }

}
