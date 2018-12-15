package cn.adair.iframe.client;

import okhttp3.Interceptor;
import retrofit2.Converter;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
public class XClientConfig {

    private static XClientConfig instance = null;

    public static XClientConfig Instance() {
        if (null == instance) {
            synchronized (XClientConfig.class) {
                if (null == instance) {
                    instance = new XClientConfig();
                }
            }
        }
        return instance;
    }

    private String xBaseUrl;

    public String _XBaseUrl() {
        return xBaseUrl;
    }

    public void _SetBaseUrl(String xBaseUrl) {
        this.xBaseUrl = xBaseUrl;
    }

    private Interceptor xLog;

    private Interceptor xHeader;

    public Interceptor _XLog() {
        return xLog;
    }

    public void _SetLog(Interceptor xLog) {
        this.xLog = xLog;
    }

    public Interceptor _XHeader() {
        return xHeader;
    }

    public void _SetHeader(Interceptor xHeader) {
        this.xHeader = xHeader;
    }

    private Converter.Factory xFactory;

    public Converter.Factory _XFactory() {
        return xFactory;
    }

    public void _SetFactory(Converter.Factory xFactory) {
        this.xFactory = xFactory;
    }
}
