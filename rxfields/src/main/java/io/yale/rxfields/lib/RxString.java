package io.yale.rxfields.lib;

/**
 * Created by YaleZheng on 2016/12/6.
 */

public class RxString extends RxField<String> {
    public RxString(String field) {
        super(field, new Comparator<String>() {
            @Override
            public boolean isEqual(String lhs, String rhs) {
                return lhs.equals(rhs);
            }
        });
    }

    public RxString(String field, Comparator<String> comparator) {
        super(field, comparator);
    }
}
