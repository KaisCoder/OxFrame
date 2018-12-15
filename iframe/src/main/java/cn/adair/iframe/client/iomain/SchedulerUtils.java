package cn.adair.iframe.client.iomain;

/**
 * com.yidao.media.request.scheduler
 * Created by Administrator on 2018/5/28/028.
 * slight negligence may lead to great disaster~
 */
public class SchedulerUtils<T> {

    public IoMainScheduler<T> ioToMain() {
        return new IoMainScheduler<T>();
    }

}
