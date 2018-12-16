package cn.adair.sample.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * cn.adair.xframe.http.interceptor
 * Created by Administrator on 2018/3/13/013.
 * slight negligence may lead to great disaster~
 */

public class IHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        //  配置请求头
        Request request = chain.request().newBuilder()
//                .header("Cookie", "JSESSIONID=" + ISPUtil.JSESSIONID())
                .header("Requested-With", "XMLHttpRequest")
                .build();
        return chain.proceed(request);
    }
}