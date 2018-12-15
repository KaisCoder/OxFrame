package cn.adair.sample.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import cn.adair.sample.BaseActivity;
import cn.adair.sample.R;

public class AboutActivity extends BaseActivity {

    @Override
    public int initLayout() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {
        ActionBar bar = getSupportActionBar();
        bar.setTitle("关于");
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


}
