package cn.adair.sample;

import android.view.MenuItem;

import cn.adair.frame.base.OxBaseActivity;
import cn.adair.frame.utils.statusbar.OxStatusBar;

public abstract class BaseActivity extends OxBaseActivity {

    @Override
    public void _SetStatusBar() {
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
