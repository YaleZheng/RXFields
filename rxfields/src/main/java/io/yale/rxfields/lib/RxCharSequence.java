package io.yale.rxfields.lib;

/**
 * Created by YaleZheng on 2016/12/6.
 */

public class RxCharSequence extends RxField<CharSequence> {
    public RxCharSequence(CharSequence field) {
        super(field, new Comparator<CharSequence>() {
            @Override
            public boolean isEqual(CharSequence lhs, CharSequence rhs) {
                return lhs.toString().equals(rhs.toString());
            }
        });
    }

    public RxCharSequence(CharSequence field, Comparator<CharSequence> comparator) {
        super(field, comparator);
    }
}
