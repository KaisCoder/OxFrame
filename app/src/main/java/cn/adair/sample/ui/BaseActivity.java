package cn.adair.sample.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;

import cn.adair.frame.utils.statusbar.OxStatusBar;
import cn.adair.sample.R;
import cn.adair.xframe.base.XActivity;

/**
 * 必须继承XActivity，你也可以每个都继承XActivity，这里进行再次封装是为了便于你维护和增加你需要的方法
 */
public abstract class BaseActivity extends XActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        String title = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(title))
            title = getString(R.string.app_name);
        ActionBar bar = getSupportActionBar();
        bar.setTitle(title);
        if (!title.equals(getString(R.string.app_name)))
            bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    protected void setStatusBar() {
        OxStatusBar.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
