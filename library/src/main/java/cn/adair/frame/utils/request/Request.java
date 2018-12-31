package cn.adair.frame.utils.request;

import java.util.concurrent.TimeUnit;

import cn.adair.frame.utils.OxPrinter;
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
public class Request {

    public static Service _CreateService() {
        ClientSet iSet = ClientSet.instance();
        Request.Builder builder = new Request.Builder();
        builder.setBaseUrl(iSet.iClientHost());
        builder.addInterceptor(iSet.iClientLog());
        builder.addInterceptor(iSet.iClientHeader());
        builder.addConverterFactory(iSet.iClientFactory());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder.builder().create(Service.class);
    }

    public static Service _CreateService(ClientSet iSet) {
        Request.Builder builder = new Request.Builder();
        builder.setBaseUrl(iSet.iClientHost());
        builder.addInterceptor(iSet.iClientLog());
        builder.addInterceptor(iSet.iClientHeader());
        builder.addConverterFactory(iSet.iClientFactory());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder.builder().create(Service.class);
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
            OxPrinter.info("addInterceptor");
            iOkBuilder.addInterceptor(interceptor);
        }

        private void addCallAdapterFactory(CallAdapter.Factory factory) {
            OxPrinter.info("addCallAdapterFactory");
            iRetrofitBuilder.addCallAdapterFactory(factory);
        }

        private void addConverterFactory(Converter.Factory factory) {
            OxPrinter.info("addConverterFactory");
            iRetrofitBuilder.addConverterFactory(factory);
        }

        private Builder setBaseUrl(String baseUrl) {
            OxPrinter.info("setBaseUrl");
            iRetrofitBuilder.baseUrl(baseUrl);
            return this;
        }

        private Retrofit builder() {
            iRetrofitBuilder.client(iOkBuilder.build());
            return iRetrofitBuilder.build();
        }

    }

}
