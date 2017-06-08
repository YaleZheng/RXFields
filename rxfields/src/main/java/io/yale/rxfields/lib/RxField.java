package io.yale.rxfields.lib;


import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxField<T> {
    private T field;
    private PublishProcessor<T> subject = PublishProcessor.create();
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
            this.subject.onNext(field);
        }
    }

    public T get() {
        return this.field;
    }

    public Flowable<Opt<T>> ob() {
        Flowable<Opt<T>> optSubject = subject.map(new Function<T, Opt<T>>() {
            @Override
            public Opt<T> apply(@NonNull T t) throws Exception {
                return new Opt<>(t);
            }
        });
        return Flowable.merge(Flowable.just(new Opt<>(field)), optSubject);
    }
}
