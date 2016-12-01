package io.yale.rxfields.ilb;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxLong {
    private long field;
    private PublishSubject<Long> subject = PublishSubject.create();

    public RxLong(long field) {
        this.field = field;
    }

    public void set(long field) {
        if (this.field != field) {
            this.field = field;
            subject.onNext(field);
        }
    }

    public long get() {
        return this.field;
    }

    public Observable<Long> ob() {
        return Observable.merge(Observable.just(field), subject);
    }

    public void add(long value) {
        set(get() + value);
    }
}
