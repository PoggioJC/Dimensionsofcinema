package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.movie.R;

public class MainActivity extends BaseActivity {

    private int time=1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (time > 0) {
                time--;
                handler.sendEmptyMessageDelayed(1, 1000);
                return;
            }
            start1();
        }
    };

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        handler.sendEmptyMessageDelayed(1,1000);
    }

    @Override
    protected void bindEvent() {

    }

    //跳转
    private void start1() {
        startActivity(new Intent(MainActivity.this,YdyActivity.class));
        //结束当前页面
        finish();
    };
}
