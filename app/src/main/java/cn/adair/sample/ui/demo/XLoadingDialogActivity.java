package cn.adair.sample.ui.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import cn.adair.frame.widget.OxLoading;
import cn.adair.sample.R;
import cn.adair.sample.ui.BaseActivity;
import cn.adair.xframe.widget.XToast;

public class XLoadingDialogActivity extends BaseActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            OxLoading.with(getApplicationContext()).dismiss();
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_xloading_dialog;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {

    }

    public void show(View view) {
        switch (view.getId()) {
            case R.id.loading1:
                OxLoading.with(this).setProgressBarColor(R.color.colorAccent).show();
                break;
            case R.id.loading2:
                XToast.info("3秒后自动取消");
                OxLoading.with(this)
                        .setBackgroundColor(Color.parseColor("#aa000000"))
                        .setMessageColor(Color.WHITE)
                        .setCanceled(false)
                        .show();
                handler.sendEmptyMessageDelayed(1, 3000);
                break;
            case R.id.loading3:
                OxLoading.with(this)
                        .setOrientation(OxLoading.VERTICAL)
                        .setMessage("加载中...")
                        .show();
                break;
            case R.id.loading4:
                XToast.info("3秒后自动取消");
                OxLoading.with(this)
                        .setCanceled(false)
                        .setOrientation(OxLoading.VERTICAL)
                        .setBackgroundColor(Color.parseColor("#aa000000"))
                        .setMessageColor(Color.WHITE)
                        .setMessage("加载中...")
                        .show();
                handler.sendEmptyMessageDelayed(1, 3000);
                break;
        }


    }
}
