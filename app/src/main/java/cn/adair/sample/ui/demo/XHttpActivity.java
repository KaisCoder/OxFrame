package cn.adair.sample.ui.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

import cn.adair.frame.utils.client.IClientSet;
import cn.adair.frame.utils.OxClient;
import cn.adair.frame.utils.OxPrinter;
import cn.adair.sample.R;
import cn.adair.sample.data.Weather;
import cn.adair.sample.ui.BaseActivity;
import cn.adair.sample.utils.InterceptorUtil;
import cn.adair.sample.utils.JsonFactory;
import cn.adair.xframe.utils.http.HttpCallBack;
import cn.adair.xframe.utils.http.XHttp;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class XHttpActivity extends BaseActivity {

    TextView text;

    @Override
    public int getLayoutId() {
        return R.layout.activity_xhttp;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        text = (TextView) findViewById(R.id.text);
    }

    public void onClick(View view) {
        request();
    }

    public void request() {

        IClientSet config = IClientSet.Instance();
        config.setClientHost("http://wthrcdn.etouch.cn");
        config.setClientLog(InterceptorUtil.CreateLog());
        config.setClientHeader(InterceptorUtil.CreateHeader());
        config.setClientFactory(JsonFactory.create());
        HashMap<String, Object> map = new HashMap<>();
        map.put("citykey", "101010100");
        new CompositeDisposable().add(OxClient._Get("/weather_mini", map).subscribe(new Consumer<JSONObject>() {
            @Override
            public void accept(JSONObject jsonObject) throws Exception {
                OxPrinter.json(jsonObject.toString());
            }
        }));

//       XRequest._Post(XClientConfig.Instance(), "", new HashMap<String, Object>()).subscribe(new io.reactivex.functions.Consumer<JSONObject>() {
//       })

        //这里是公用接口，没有办法演示传参，谅解
        String url = "http://wthrcdn.etouch.cn/weather_mini?citykey=101010100";
        /**
         * 调用 网络请求 get方法
         * @param url 请求url
         * @param params 参数，没有可以传一个空集合 or null
         * @param HttpCallBack<T> 回调接口，T 为你想返回的类型（String or entity）
         */
        XHttp.obtain().get(url, null, new HttpCallBack<Weather>() {
            //成功返回你传入的返回类型
            @Override
            public void onSuccess(Weather weather) {
                text.setText(
                        weather.getData().getCity() + " \n温度：" +
                                weather.getData().getWendu() + "度 \n 提示：" +
                                weather.getData().getGanmao()
                );
            }

            @Override
            public void onFailed(String str) {
                text.setText(str);
            }
        });
    }

}
