package cn.adair.sample.ui.demo;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.adair.sample.ui.BaseActivity;
import cn.adair.sample.R;
import cn.adair.sample.bean.News;
import cn.adair.xframe.cache.XCache;
import cn.adair.xframe.utils.XOutdatedUtils;

public class XCacheActivity extends BaseActivity {

    TextView cacheText;
    ImageView cacheImage;
    XCache xCache;

    @Override
    public int getLayoutId() {
        return R.layout.activity_xcache;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        cacheText = (TextView) findViewById(R.id.cacheText);
        cacheImage = (ImageView) findViewById(R.id.cacheImage);
        xCache = XCache.get(this);
        xCache.put("string", "缓存普通字符串");
        News news = new News(News.TYPE_SINGLE_PICTURE, "智能手机行业正处于关键转折点，下一战场会在哪里？", "https://pic.36krcnd.com/avatar/201701/17062818/1ucsedy4pdb4aqyu.jpg!heading", "缪定纯•明星公司", "58分钟前");
        xCache.put("news", news);//保存序列化对象
        xCache.put("bitmap", BitmapFactory.decodeResource(getResources(), R.mipmap.computer));
        xCache.put("drawable", XOutdatedUtils.getDrawable(R.mipmap.computer));
        xCache.put("byte", "缓存byte".getBytes());//字节数组，使用场景很多，这里只做测试
        /**
         * 关于实体类保存，建议用json字符串保存，效果更佳，兼容性更好
         */
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                cacheText.setText(xCache.getAsString("string"));
                break;
            case R.id.button2:
                cacheImage.setImageBitmap(xCache.getAsBitmap("bitmap"));
                break;
            case R.id.button3:
                cacheImage.setImageDrawable(xCache.getAsDrawable("drawable"));
                break;
            case R.id.button4:
                cacheText.setText(((News) xCache.getAsObject("news")).toString());
                break;
            case R.id.button5:
                cacheText.setText(new String(xCache.getAsBinary("byte")));
                break;
        }
    }

}
