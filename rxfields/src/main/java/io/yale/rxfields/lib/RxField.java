package io.yale.rxfields.lib;


import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxField<T> {
    private T field;
    private PublishSubject<T> subject = PublishSubject.create();
    private Comparator<T> comparator;

    public RxField(T field) {
        this(field, null);
    }

    public RxField(T field, Comparator<T> comparator) {
        this.field = field;
        this.comparator = comparator;
        if (this.comparator == null) {
            this.comparator = new Comparator<T>() {
                @Override
                public boolean isEqual(T lhs, T rhs) {
                    return lhs == rhs || (lhs != null && rhs != null && lhs.equals(rhs));
                }
            };
        }
    }

    public void set(T field) {
        set(field, false);
    }

    public void set(T field, boolean forceNotify) {
        boolean isSame = this.field != field && !this.comparator.isEqual(this.field, field);
        if (isSame) {
            this.field = field;
        }
        if (!isSame || forceNotify) {
            this.subject.onNext(field);
        }
    }

    public T get() {
        return this.field;
    }

    public Observable<T> ob() {
        return Observable.merge(Observable.just(field), subject);
    }
}
