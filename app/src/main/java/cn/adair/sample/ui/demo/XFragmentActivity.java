package cn.adair.sample.ui.demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.adair.frame.base.OxBaseActivity;
import cn.adair.sample.R;
import cn.adair.sample.adapter.FragmentAdapter;
import cn.adair.sample.fragment.AFragment;
import cn.adair.sample.fragment.BFragment;
import cn.adair.sample.fragment.CFragment;

/**
 * cn.adair.sample.ui.demo
 * Created by WangChangYun on 2019/10/22 13:54
 * slight negligence may lead to great disaster~
 */
public class XFragmentActivity extends OxBaseActivity {

    @Override
    protected void _SetStatusBar() {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_xfragment;
    }

    private ViewPager mViewPager;
    private List<Fragment> mViewList;
    private FragmentAdapter mFragmentAdapter;

    @Override
    public void initView() {
        mViewPager = findViewById(R.id.viewpager);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mViewList = new ArrayList<Fragment>();
        mViewList.add(new AFragment());
        mViewList.add(new BFragment());
        mViewList.add(new CFragment());
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mViewList);
        mViewPager.setAdapter(mFragmentAdapter);
    }

}
