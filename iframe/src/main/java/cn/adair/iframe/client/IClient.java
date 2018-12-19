package cn.adair.iframe.client;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
class IClient {

    static IService _CreateService() {
        IClientConfig xConfig = IClientConfig.Instance();
        IClient.Builder builder = new IClient.Builder();
        builder.addInterceptor(xConfig._XLog());
        builder.addInterceptor(xConfig._XHeader());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.addConverterFactory(xConfig._XFactory());
        builder.setBaseUrl(xConfig._XBaseUrl());
        return builder.builder().create(IService.class);
    }

    public static class Builder {

        private OkHttpClient.Builder iOkBuilder;
        private Retrofit.Builder iRetrofitBuilder;

        Builder() {
            iOkBuilder = new OkHttpClient.Builder();
            iRetrofitBuilder = new Retrofit.Builder();
            iOkBuilder.readTimeout(60L, TimeUnit.SECONDS);
            iOkBuilder.writeTimeout(60L, TimeUnit.SECONDS);
            iOkBuilder.connectTimeout(60L, TimeUnit.SECONDS);
        }

        private Builder addInterceptor(Interceptor interceptor) {
            Log.e("IClient", "addInterceptor");
            iOkBuilder.addInterceptor(interceptor);
            return this;
        }

        private Builder addCallAdapterFactory(CallAdapter.Factory factory) {
            Log.e("IClient", "addCallAdapterFactory");
            iRetrofitBuilder.addCallAdapterFactory(factory);
            return this;
        }

        private Builder addConverterFactory(Converter.Factory factory) {
            Log.e("IClient", "addConverterFactory");
            iRetrofitBuilder.addConverterFactory(factory);
            return this;
        }

        private Builder setBaseUrl(String baseUrl) {
            Log.e("IClient", "setBaseUrl");
            iRetrofitBuilder.baseUrl(baseUrl);
            return this;
        }

        private Retrofit builder() {
            iRetrofitBuilder.client(iOkBuilder.build());
            return iRetrofitBuilder.build();
        }

    }

}
