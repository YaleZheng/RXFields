package io.yale.rxfields.lib;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxShort {
    private short field;
    private PublishSubject<Short> subject = PublishSubject.create();

    public RxShort(short field) {
        this.field = field;
    }

    public void set(short field) {
        if (this.field != field) {
            this.field = field;
            subject.onNext(field);
        }
    }

    public short get() {
        return this.field;
    }

    public Observable<Short> ob() {
        return Observable.merge(Observable.just(field), subject);
    }

    public void add(short value) {
        set((short) (get() + value));
    }
}
