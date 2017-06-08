package io.yale.rxfields.lib;

import io.reactivex.annotations.NonNull;

/**
 * Created by YaleZheng on 2016/12/6.
 */

public class RxCharSequence extends RxField<CharSequence> {
    public RxCharSequence(@NonNull CharSequence field) {
        super(field, new Comparator<CharSequence>() {
            @Override
            public boolean isEqual(CharSequence lhs, CharSequence rhs) {
                return (lhs == rhs) || (lhs != null && rhs != null && lhs.toString().equals(rhs.toString()));
            }
        });
    }
}
