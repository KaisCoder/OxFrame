package cn.adair.frame.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.HashMap;

import cn.adair.frame.utils.request.ClientSet;
import cn.adair.frame.utils.request.Request;
import cn.adair.frame.utils.request.scheduler.SchedulerUtil;
import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
public class OxClient {

    public static Observable<JSONObject> _Get(String iUri, HashMap<String, Object> iParams) {
        return Request._CreateService()._Get(iUri, iParams).compose(new SchedulerUtil<JSONObject>().ioToMain());
    }

    public static Observable<JSONObject> _Get(ClientSet iSet, String iUri, HashMap<String, Object> iParams) {
        return Request._CreateService(iSet)._Get(iUri, iParams).compose(new SchedulerUtil<JSONObject>().ioToMain());
    }

    public static Observable<JSONObject> _Post(String iUri, HashMap<String, Object> iParams) {
        return Request._CreateService()._Post(iUri, iParams).compose(new SchedulerUtil<JSONObject>().ioToMain());
    }

    public static Observable<JSONObject> _Upload(String iUri, HashMap<String, Object> iParams, File iFile) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), iFile);
        MultipartBody.Part iPart = MultipartBody.Part.createFormData("file", iFile.getName(), requestFile);
        return Request._CreateService()._Upload(iUri, iParams, iPart).compose(new SchedulerUtil<JSONObject>().ioToMain());
    }

}
