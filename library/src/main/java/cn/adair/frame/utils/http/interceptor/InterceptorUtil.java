package cn.adair.frame.utils.http.interceptor;

import android.util.Log;

import okhttp3.Interceptor;

/**
 * cn.adair.xframe.http
 * Created by Administrator on 2018/3/12/012.
 * slight negligence may lead to great disaster~
 */

public class InterceptorUtil {

    /**
     * 日志打印操作
     */
    public static Interceptor _CreateLog() {
        LogsInterceptor logInterceptor = new LogsInterceptor(new LogsInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("NetWork", message);
            }
        });
        logInterceptor.setLevel(LogsInterceptor.Level.BASIC);
        return logInterceptor;
    }

    /**
     * 请求头等配置操作
     */
    public static Interceptor _CreateHeader() {
        return new IHeaderInterceptor();
    }

}
