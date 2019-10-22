package cn.adair.frame.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class OxBaseActivity extends AppCompatActivity implements OxBaseCallback {

    public Context _mContext;
    public Activity _mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initData(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        _SetStatusBar();
        _mContext = this;
        _mActivity = this;
    }

    /**
     * 状态栏设置
     */
    protected abstract void _SetStatusBar();

}
