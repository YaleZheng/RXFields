package io.yale.rxfields.lib;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxInt {
    private int field;
    private PublishSubject<Integer> subject = PublishSubject.create();

    public RxInt(int field) {
        this.field = field;
    }

    public void set(int field) {
        if (this.field != field) {
            this.field = field;
            subject.onNext(field);
        }
    }

    public int get() {
        return this.field;
    }

    public Observable<Integer> ob() {
        return Observable.merge(Observable.just(field), subject);
    }

    public void add(int value) {
        set(get() + value);
    }
}
