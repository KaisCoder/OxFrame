package cn.adair.frame.utils;

import java.util.HashMap;

import cn.adair.frame.utils.http.scheduler.SchedulerUtils;
import cn.adair.frame.utils.http.service.OxService;
import io.reactivex.Observable;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
public class OxRequest {

    public static Observable<String> _Get(OxService iService, String iUri) {
        return iService._Get(iUri, new HashMap<String, Object>()).compose(new SchedulerUtils<String>().ioToMain());
    }

    public static Observable<String> _Get(OxService iService, String iUri, HashMap<String, Object> iParams) {
        return iService._Get(iUri, iParams).compose(new SchedulerUtils<String>().ioToMain());
    }

    public static Observable<String> _Post(OxService iService, String iUri, HashMap<String, Object> iParams) {
        return iService._Post(iUri, iParams).compose(new SchedulerUtils<String>().ioToMain());
    }
//
//    public Observable<JSONObject> _Get(IClientSet iSet, String iUri, HashMap<String, Object> iParams) {
//        return IClient._CreateService(iSet)._Get(iUri, iParams).compose(new SchedulerUtils<JSONObject>().ioToMain());
//    }

//    public Observable<JSONObject> _Post(String iUri, HashMap<String, Object> iParams) {
//        return iService._Post(iUri, iParams).compose(new SchedulerUtils<JSONObject>().ioToMain());
//    }
//
//    public Observable<JSONObject> _Post(IClientSet iSet, String iUri, HashMap<String, Object> iParams) {
//        return IClient._CreateService(iSet)._Post(iUri, iParams).compose(new SchedulerUtils<JSONObject>().ioToMain());
//    }
//
//    public Observable<JSONObject> _Upload(String iUri, HashMap<String, Object> iParams, File iFile) {
//        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), iFile);
//        MultipartBody.Part iPart = MultipartBody.Part.createFormData("file", iFile.getName(), requestFile);
//        return iService._Upload(iUri, iParams, iPart).compose(new SchedulerUtils<JSONObject>().ioToMain());
//    }

}
