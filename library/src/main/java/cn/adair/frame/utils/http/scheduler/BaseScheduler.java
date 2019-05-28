/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.adair.frame.utils.http.scheduler;

import org.reactivestreams.Publisher;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;

/**
 * com.yidao.media.request.scheduler
 * Created by Administrator on 2018/5/28/028.
 * slight negligence may lead to great disaster~
 */
public abstract class BaseScheduler<T> implements ObservableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer, FlowableTransformer<T, T> {

    private Scheduler observeOnScheduler;
    private Scheduler subscribeOnScheduler;

    BaseScheduler(Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        this.observeOnScheduler = observeOnScheduler;
        this.subscribeOnScheduler = subscribeOnScheduler;
    }

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler);
    }

    @Override
    public SingleSource<T> apply(Single<T> upstream) {
        return upstream.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler);
    }

    @Override
    public MaybeSource<T> apply(Maybe<T> upstream) {
        return upstream.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler);
    }

    @Override
    public Publisher<T> apply(Flowable<T> upstream) {
        return upstream.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler);
    }

    @Override
    public CompletableSource apply(Completable upstream) {
        return upstream.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler);
    }
}
