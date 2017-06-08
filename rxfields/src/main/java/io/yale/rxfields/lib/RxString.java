package io.yale.rxfields.lib;

import io.reactivex.annotations.NonNull;

/**
 * Created by YaleZheng on 2016/12/6.
 */

public class RxString extends RxField<String> {

    public RxString() {
        super(null);
    }

    public RxString(@NonNull String field) {
        super(field);
    }
}
