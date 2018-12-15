package cn.adair.iframe.client;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
class XClient {

    private static OkHttpClient _BuilderOkClient(XClientConfig xConfig) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(60L, TimeUnit.SECONDS);
        builder.writeTimeout(60L, TimeUnit.SECONDS);
        builder.connectTimeout(60L, TimeUnit.SECONDS);
        builder.addInterceptor(xConfig._XLog());
        builder.addInterceptor(xConfig._XHeader());
        return builder.build();
    }

    private static Retrofit _BuildRetorfit(XClientConfig xConfig) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.baseUrl(xConfig._XBaseUrl()); // 设置BaseUrl
        builder.client(_BuilderOkClient(xConfig));
        builder.addConverterFactory(xConfig._XFactory());
        return builder.build();
    }

    static XService _CreateService(XClientConfig xConfig) {
        return _BuildRetorfit(xConfig).create(XService.class);
    }

}
