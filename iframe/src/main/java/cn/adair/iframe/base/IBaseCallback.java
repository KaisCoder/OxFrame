package cn.adair.iframe.base;

import android.os.Bundle;

public interface IBaseCallback {

    /**
     * 布局id
     */
    int initLayout();

    /**
     * 初始化布局控件
     */
    void initView();

    /**
     * 初始化数据
     */
    void initData(Bundle savedInstanceState);

}
