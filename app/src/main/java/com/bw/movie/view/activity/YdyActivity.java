package com.bw.movie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.bw.movie.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YdyActivity extends BaseActivity {


    private ArrayList<View> img = new ArrayList<>();
    private ViewPager ydy;
    private RadioGroup group_ydy;

    @Override
    protected int bindLayout() {
        return R.layout.activity_ydy;
    }

    @Override
    protected void initView() {
        ydy = bindView(R.id.ydy);
        group_ydy = bindView(R.id.group_ydy);
    }

    @Override
    protected void initData() {
        SharedPreferences sp_ydy = getSharedPreferences("ydy", Context.MODE_PRIVATE);
        if (sp_ydy.getBoolean("第一次",false)){
            Intent intent = new Intent(YdyActivity.this,ShowActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        //获取编辑器
        SharedPreferences.Editor edit = sp_ydy.edit();
        //存值
        edit.putBoolean("第一次",true);
        //提交事务
        edit.commit();
        group_ydy.check(group_ydy.getChildAt(0).getId());
        View view1  = View.inflate(this, R.layout.fragment_page_one, null);
        img.add(view1);
        View view2  = View.inflate(this, R.layout.fragment_page_two, null);
        img.add(view2);
        View view3  = View.inflate(this, R.layout.fragment_page_three, null);
        img.add(view3);
        View view4  = View.inflate(this, R.layout.fragment_page_four, null);
        img.add(view4);
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YdyActivity.this,ShowActivity.class);
                startActivity(intent);
                finish();
            }
        });
        this.ydy.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return img.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView( img.get( position ) );
                return img.get( position );
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });


    }



    @Override
    protected void bindEvent() {
        ydy.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                group_ydy.check(group_ydy.getChildAt(i).getId());

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
