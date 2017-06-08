package io.yale.rxfields.lib;

import io.reactivex.annotations.NonNull;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxInt extends RxField<Integer> {
    public RxInt() {
        super(0);
    }

    public RxInt(Integer field) {
        super(field);
    }

    public void add(int value) {
        set(get() + value);
    }
}
