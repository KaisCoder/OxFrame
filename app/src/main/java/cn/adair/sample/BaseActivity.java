package cn.adair.sample;

import android.view.MenuItem;

import cn.adair.iframe.base.IBaseActivity;
import cn.adair.xframe.utils.statusbar.XStatusBar;

public abstract class BaseActivity extends IBaseActivity {

    @Override
    public void _SetStatusBar() {
        XStatusBar.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
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
