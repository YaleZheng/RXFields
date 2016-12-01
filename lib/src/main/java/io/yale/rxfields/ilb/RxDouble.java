package io.yale.rxfields.ilb;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxDouble {
    private double field;
    private PublishSubject<Double> subject = PublishSubject.create();

    public RxDouble(double field) {
        this.field = field;
    }

    public void set(double field) {
        if (this.field != field) {
            this.field = field;
            subject.onNext(field);
        }
    }

    public double get() {
        return this.field;
    }

    public Observable<Double> ob() {
        return Observable.merge(Observable.just(field), subject);
    }

    public void add(double value) {
        set(get() + value);
    }
}
