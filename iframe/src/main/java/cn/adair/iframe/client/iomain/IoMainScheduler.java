package cn.adair.iframe.client.iomain;

import cn.adair.iframe.client.rxandroid.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * com.yidao.media.request.scheduler
 * Created by Administrator on 2018/5/28/028.
 * slight negligence may lead to great disaster~
 */
class IoMainScheduler<T> extends BaseScheduler<T> {

    IoMainScheduler() {
        super(Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
