package io.yale.rxfields.lib;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxDouble extends RxField<Double> {

    public RxDouble() {
        super(0D);
    }

    public RxDouble(Double field) {
        super(field);
    }

    public void add(double value) {
        set(get() + value);
    }
}
