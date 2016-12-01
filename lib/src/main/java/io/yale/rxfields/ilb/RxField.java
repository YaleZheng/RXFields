package io.yale.rxfields.ilb;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxField<T> {
    private T field;
    private PublishSubject<T> subject = PublishSubject.create();

    public RxField(T field) {
        this.field = field;
    }

    public void set(T field) {
        if (this.field != field) {
            this.field = field;
            subject.onNext(field);
        }
    }

    public T get() {
        return this.field;
    }

    public Observable<T> ob() {
        return Observable.merge(Observable.just(field), subject);
    }
}
