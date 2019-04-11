package com.bw.movie.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());

        initView();
        initData();

        bindEvent();
    }

    protected abstract int bindLayout();

    protected abstract void initView();

     protected abstract void initData();

    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resId){
        return (T) findViewById(resId);
    }

    public void ToastData(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
