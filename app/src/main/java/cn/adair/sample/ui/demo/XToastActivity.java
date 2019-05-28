package cn.adair.sample.ui.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.adair.frame.utils.OxToast;
import cn.adair.sample.ui.BaseActivity;
import cn.adair.sample.R;
import cn.adair.frame.utils.OxOutdatedUtil;
import cn.adair.xframe.widget.XToast;

public class XToastActivity extends BaseActivity implements View.OnClickListener {
    Button error;
    Button success;
    Button info;
    Button warning;
    Button normalNoIcon;
    Button normalIcon;
    Button custom;

    @Override
    public int getLayoutId() {
        return R.layout.activity_xtoast;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void initView() {
        error = (Button) findViewById(R.id.button_error_toast);
        success = (Button) findViewById(R.id.button_success_toast);
        info = (Button) findViewById(R.id.button_info_toast);
        warning = (Button) findViewById(R.id.button_warning_toast);
        normalNoIcon = (Button) findViewById(R.id.button_normal_no_icon);
        normalIcon = (Button) findViewById(R.id.button_normal_icon);
        custom = (Button) findViewById(R.id.button_custom);
        error.setOnClickListener(this);
        success.setOnClickListener(this);
        info.setOnClickListener(this);
        warning.setOnClickListener(this);
        normalNoIcon.setOnClickListener(this);
        normalIcon.setOnClickListener(this);
        custom.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_error_toast:
                OxToast.showLong("Toast is Show");
//                XToast.error("xloading_error！！");
                break;
            case R.id.button_success_toast:
                XToast.success("success！！");
                break;
            case R.id.button_warning_toast:
                XToast.warning("warning！！");
                break;
            case R.id.button_info_toast:
                XToast.info("info！！");
                break;
            case R.id.button_normal_icon:
                XToast.normal("success！！", OxOutdatedUtil.getDrawable(R.mipmap.currerror));
                break;
            case R.id.button_normal_no_icon:
                XToast.normal("normal！！");
                break;
            case R.id.button_custom:
                XToast.custom("自定义！！！", R.mipmap.error2, Color.RED, Color.WHITE, Toast.LENGTH_SHORT);
                break;
        }
    }
}
