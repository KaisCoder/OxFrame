package cn.adair.sample.utils;

import okhttp3.Interceptor;

/**
 * cn.adair.xframe.http
 * Created by Administrator on 2018/3/12/012.
 * slight negligence may lead to great disaster~
 */

public class InterceptorUtil {

    /**
     * 日志打印操作
     *
     * @return
     */
    public static Interceptor CreateLog() {
        ILogsInterceptor logInterceptor = new ILogsInterceptor(new ILogsInterceptor.Logger() {
            @Override
            public void log(String message) {
//                IPrinter.e(message);
            }
        });
        logInterceptor.setLevel(ILogsInterceptor.Level.BASIC);
        return logInterceptor;
    }

    /**
     * 请求头等配置操作
     *
     * @return
     */
    public static Interceptor CreateHeader() {
        return new IHeaderInterceptor();
    }

}
