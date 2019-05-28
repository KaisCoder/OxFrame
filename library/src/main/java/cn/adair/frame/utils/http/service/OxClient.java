package cn.adair.frame.utils.http.service;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
public class OxClient {

    private OkHttpClient.Builder mOkBuilder;
    private Retrofit.Builder mRetrofitBuilder;

    public OxClient() {
        mOkBuilder = new OkHttpClient.Builder();
        mRetrofitBuilder = new Retrofit.Builder();
        mOkBuilder.readTimeout(60L, TimeUnit.SECONDS);
        mOkBuilder.writeTimeout(60L, TimeUnit.SECONDS);
        mOkBuilder.connectTimeout(60L, TimeUnit.SECONDS);
    }

    public void addInterceptor(Interceptor interceptor) {
        mOkBuilder.addInterceptor(interceptor);
    }

    public void addCallAdapterFactory(CallAdapter.Factory factory) {
        mRetrofitBuilder.addCallAdapterFactory(factory);
    }

    public void addConverterFactory(Converter.Factory factory) {
        mRetrofitBuilder.addConverterFactory(factory);
    }

    public void baseUrl(String baseUrl) {
        mRetrofitBuilder.baseUrl(baseUrl);
    }

    public Retrofit builder() {
        mRetrofitBuilder.client(mOkBuilder.build());
        return mRetrofitBuilder.build();
    }

}
