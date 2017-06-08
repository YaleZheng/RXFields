package io.yale.rxfields.lib;


import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.processors.PublishProcessor;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxField<T> {
    private T field;
    private PublishProcessor<T> subject = PublishProcessor.create();
    private Comparator<T> comparator;

    public RxField(@NonNull T field) {
        this(field, null);
    }

    public RxField(@NonNull T field, Comparator<T> comparator) {
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

    public void set(@NonNull T field) {
        set(field, false);
    }

    public void set(@NonNull T field, boolean forceNotify) {
        boolean notSame = this.field != field && !this.comparator.isEqual(this.field, field);
        if (notSame) {
            this.field = field;
        }
        if (notSame || forceNotify) {
            this.subject.onNext(field);
        }
    }

    public
    @NonNull
    T get() {
        return this.field;
    }

    @NonNull
    public Flowable<T> ob() {
        return Flowable.merge(Flowable.just(field), subject);
    }
}
