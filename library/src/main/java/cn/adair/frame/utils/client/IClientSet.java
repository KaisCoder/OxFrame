package cn.adair.frame.utils.client;

import okhttp3.Interceptor;
import retrofit2.Converter;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
public class IClientSet {

    private static IClientSet iInstance = null;

    public static IClientSet Instance() {
        if (null == iInstance) {
            synchronized (IClientSet.class) {
                if (null == iInstance) {
                    iInstance = new IClientSet();
                }
            }
        }
        return iInstance;
    }

    private String clientHost;
    private Interceptor clientLog;
    private Interceptor clientHeader;
    private Converter.Factory clientFactory;

    String iClientHost() {
        return clientHost;
    }

    public void setClientHost(String clientHost) {
        this.clientHost = clientHost;
    }

    Interceptor iClientLog() {
        return clientLog;
    }

    public void setClientLog(Interceptor clientLog) {
        this.clientLog = clientLog;
    }

    Interceptor iClientHeader() {
        return clientHeader;
    }

    public void setClientHeader(Interceptor clientHeader) {
        this.clientHeader = clientHeader;
    }

    Converter.Factory iClientFactory() {
        return clientFactory;
    }

    public void setClientFactory(Converter.Factory clientFactory) {
        this.clientFactory = clientFactory;
    }
}
