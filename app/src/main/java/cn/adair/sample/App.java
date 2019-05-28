package cn.adair.sample;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cn.adair.frame.OxFrame;
import cn.adair.sample.http.AsyncHttpEngine;
import cn.adair.sample.loder.GlideImageLoader;
import cn.adair.xframe.XFrame;
import cn.adair.xframe.base.XApplication;

public class App extends XApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        CustomActivityOnCrash.install(this);
        OxFrame.init(this);
        OxFrame.initPrinter("OxRun", true, false);


        //初始化多状态界面View
        XFrame.initXLoadingView().setErrorViewResId(R.layout._loading_layout_error);

        /**
         初始化网络请求的引擎,在这里可以一行代码切换，避免更换网络框架麻烦的问题
         提供三种常见框架的简单案例：（你也可以按照例子自己实现）
         AsyncHttpEngine、OKHttpEngine、VolleyHttpEngine
         */
        XFrame.initXHttp(new AsyncHttpEngine());

        /**
         * 初始化全局图片加载框架
         * GlideImageLoader为你的图片加载框架实现类
         */
        XFrame.initXImageLoader(new GlideImageLoader(getApplicationContext()));

        /**
         * 更名后
         */
        OxFrame.init(this);

    }
}
