package cn.adair.sample.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import cn.adair.frame.utils.OxPrinter;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * cn.city.driver.http
 * Created by Administrator on 2018/4/12/012.
 * slight negligence may lead to great disaster~
 */
public class JsonResponseConverter implements Converter<ResponseBody, JSONObject> {

    @Override
    public JSONObject convert(ResponseBody value) throws IOException {
        BufferedSource bufferedSource = Okio.buffer(value.source());
        String result = bufferedSource.readUtf8();
        bufferedSource.close();
        OxPrinter.e("解密前：--->" + result);
        return JSONObject.parseObject(result);
    }
}
