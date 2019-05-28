package cn.adair.frame.utils.http.interceptor;

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
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .build();
        return chain.proceed(request);
    }
}