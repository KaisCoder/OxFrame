package cn.adair.sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cn.adair.sample.BaseActivity;
import cn.adair.sample.R;
import cn.adair.sample.ui.adapter.MyFragmentPagerAdapter;


public class MainActivity extends BaseActivity {
    private List<Fragment> fragments;
    private String[] titles = new String[]{"Demo", "API"};
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        fragments = new ArrayList<>();
        fragments.add(new DemoFragment());
        fragments.add(new APIFragment());

    }

    @Override
    public void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText(titles[0]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[1]));
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                startActivity(new Intent(this, AboutActivity.class)
                        .putExtra("title", "关于XFrame"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
