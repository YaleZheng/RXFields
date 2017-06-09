package io.yale.rxfields.lib;


import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxField<T> {
    private T field;
    private PublishSubject<Opt<T>> subject = PublishSubject.create();
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
        boolean notSame = this.field != field && !this.comparator.isEqual(this.field, field);
        if (notSame) {
            this.field = field;
        }
        if (notSame || forceNotify) {
            this.subject.onNext(new Opt<>(field));
        }
    }

    public T get() {
        return this.field;
    }

    public Observable<Opt<T>> ob() {
        return Observable.merge(Observable.just(new Opt<>(field)), subject);
    }
}
