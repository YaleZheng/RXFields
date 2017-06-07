package io.yale.rxfields.lib;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxShort extends RxField<Short> {

    public RxShort() {
        super((short) 0);
    }

    public RxShort(Short field) {
        super(field);
    }

    public void add(short value) {
        set((short) (get() + value));
    }
}
