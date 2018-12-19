package cn.adair.iframe.client.scheduler;

import io.reactivex.schedulers.Schedulers;

/**
 * com.yidao.media.request.scheduler
 * Created by Administrator on 2018/5/28/028.
 * slight negligence may lead to great disaster~
 */
public class SchedulerUtils<T> {

    public IoMainScheduler<T> ioToMain() {
        return new IoMainScheduler<T>();
    }

    class IoMainScheduler<T> extends BaseScheduler<T> {

        IoMainScheduler() {
            super(Schedulers.io(), AndroidSchedulers.mainThread());
        }

    }

}
