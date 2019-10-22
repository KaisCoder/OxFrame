package cn.adair.sample;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cn.adair.frame.OxFrame;
import cn.adair.frame.utils.OxPrinter;
import cn.adair.sample.activity.AboutActivity;
import cn.adair.sample.fragment.APIFragment;
import cn.adair.sample.fragment.DemoFragment;
import cn.adair.sample.ui.adapter.MyFragmentPagerAdapter;

public class MainActivity extends BaseActivity {

    private List<Fragment> fragments;
    private String[] titles = new String[]{"Demo", "API"};
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        fragments = new ArrayList<>();
        fragments.add(new DemoFragment());
        fragments.add(new APIFragment());
        tabLayout.addTab(tabLayout.newTab().setText(titles[0]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[1]));
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);

        OxPrinter.error(OxFrame.iPackageName());

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
                startActivity(new Intent(this, AboutActivity.class).putExtra("title", "关于XFrame"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
