package cn.adair.iframe.client;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.HashMap;

import cn.adair.iframe.client.scheduler.SchedulerUtils;
import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
public class IRequest {

    public static Observable<JSONObject> _Post(IClientConfig xConfig, String iUri, HashMap<String, Object> iParams) {
        return IClient._CreateService()._Post(iUri, iParams).compose(new SchedulerUtils<JSONObject>().ioToMain());
    }

    public static Observable<JSONObject> _Get(String iUri, HashMap<String, Object> iParams) {
        return IClient._CreateService()._Get(iUri, iParams).compose(new SchedulerUtils<JSONObject>().ioToMain());
    }

    public static Observable<JSONObject> _Upload(IClientConfig xConfig, String iUri, HashMap<String, Object> iParams, File iFile) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), iFile);
        MultipartBody.Part iPart = MultipartBody.Part.createFormData("file", iFile.getName(), requestFile);
        return IClient._CreateService()._Upload(iUri, iParams, iPart).compose(new SchedulerUtils<JSONObject>().ioToMain());
    }

}
