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
        IClientSet iSet = IClientSet.Instance();
        IClient.Builder builder = new IClient.Builder();
        builder.setBaseUrl(iSet.iClientHost());
        builder.addInterceptor(iSet.iClientLog());
        builder.addInterceptor(iSet.iClientHeader());
        builder.addConverterFactory(iSet.iClientFactory());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder.builder().create(IService.class);
    }

    static IService _CreateService(IClientSet iSet) {
        IClient.Builder builder = new IClient.Builder();
        builder.setBaseUrl(iSet.iClientHost());
        builder.addInterceptor(iSet.iClientLog());
        builder.addInterceptor(iSet.iClientHeader());
        builder.addConverterFactory(iSet.iClientFactory());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
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

        private void addInterceptor(Interceptor interceptor) {
            Log.e("IClient", "addInterceptor");
            iOkBuilder.addInterceptor(interceptor);
        }

        private void addCallAdapterFactory(CallAdapter.Factory factory) {
            Log.e("IClient", "addCallAdapterFactory");
            iRetrofitBuilder.addCallAdapterFactory(factory);
        }

        private void addConverterFactory(Converter.Factory factory) {
            Log.e("IClient", "addConverterFactory");
            iRetrofitBuilder.addConverterFactory(factory);
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
