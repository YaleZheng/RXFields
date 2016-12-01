package io.yale.rxfields.lib;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxBoolean {
    private boolean field;
    private PublishSubject<Boolean> subject = PublishSubject.create();

    public RxBoolean(boolean field) {
        this.field = field;
    }

    public void set(boolean field) {
        if (this.field != field) {
            this.field = field;
            subject.onNext(field);
        }
    }

    public boolean get() {
        return this.field;
    }

    public Observable<Boolean> ob() {
        return Observable.merge(Observable.just(field), subject);
    }

    public void toggle() {
        set(!get());
    }

    public boolean TRUE() {
        return get();
    }

    public boolean FALSE() {
        return !get();
    }
}
