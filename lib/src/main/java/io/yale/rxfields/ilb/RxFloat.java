package io.yale.rxfields.ilb;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxFloat {
    private float field;
    private PublishSubject<Float> subject = PublishSubject.create();

    public RxFloat(float field) {
        this.field = field;
    }

    public void set(float field) {
        if (this.field != field) {
            this.field = field;
            subject.onNext(field);
        }
    }

    public float get() {
        return this.field;
    }

    public Observable<Float> ob() {
        return Observable.merge(Observable.just(field), subject);
    }

    public void add(float value) {
        set(get() + value);
    }
}
