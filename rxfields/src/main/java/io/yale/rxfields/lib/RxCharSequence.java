package io.yale.rxfields.lib;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxCharSequence<T> {
    private CharSequence field;
    private PublishSubject<CharSequence> subject = PublishSubject.create();

    public RxCharSequence(CharSequence field) {
        this.field = field;
    }

    public void set(CharSequence field) {
        if (this.field != field && !this.field.toString().equals(field.toString())) {
            this.field = field;
            subject.onNext(field);
        }
    }

    public CharSequence get() {
        return this.field;
    }

    public Observable<CharSequence> ob() {
        return Observable.merge(Observable.just(field), subject);
    }
}
