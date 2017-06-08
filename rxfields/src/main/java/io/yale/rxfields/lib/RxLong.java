package io.yale.rxfields.lib;

import io.reactivex.annotations.NonNull;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxLong extends RxField<Long> {
    public RxLong() {
        super(0L);
    }

    public RxLong(@NonNull Long field) {
        super(field);
    }

    public void add(long value) {
        set(get() + value);
    }
}
