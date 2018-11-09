package cn.adair.sample.ui.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import cn.adair.sample.BaseActivity;
import cn.adair.sample.R;
import cn.adair.xframe.widget.XLoadingDialog;
import cn.adair.xframe.widget.XToast;

public class XLoadingDialogActivity extends BaseActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            XLoadingDialog.with(getApplicationContext()).dismiss();
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
                XLoadingDialog.with(this).show();
                break;
            case R.id.loading2:
                XToast.info("3秒后自动取消");
                XLoadingDialog.with(this)
                        .setBackgroundColor(Color.parseColor("#aa000000"))
                        .setMessageColor(Color.WHITE)
                        .setCanceled(false)
                        .show();
                handler.sendEmptyMessageDelayed(1, 3000);
                break;
            case R.id.loading3:
                XLoadingDialog.with(this)
                        .setOrientation(XLoadingDialog.VERTICAL)
                        .setMessage("加载中...")
                        .show();
                break;
            case R.id.loading4:
                XToast.info("3秒后自动取消");
                XLoadingDialog.with(this)
                        .setCanceled(false)
                        .setOrientation(XLoadingDialog.VERTICAL)
                        .setBackgroundColor(Color.parseColor("#aa000000"))
                        .setMessageColor(Color.WHITE)
                        .setMessage("加载中...")
                        .show();
                handler.sendEmptyMessageDelayed(1, 3000);
                break;
        }


    }
}
