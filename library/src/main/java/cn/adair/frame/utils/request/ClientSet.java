package cn.adair.frame.utils.request;

import okhttp3.Interceptor;
import retrofit2.Converter;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
public class ClientSet {

    private static ClientSet instance = null;

    public static ClientSet instance() {
        if (null == instance) {
            synchronized (ClientSet.class) {
                if (null == instance) {
                    instance = new ClientSet();
                }
            }
        }
        return instance;
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
