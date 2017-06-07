package io.yale.rxfields.lib;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxBoolean extends RxField<Boolean> {
    public RxBoolean() {
        super(false);
    }

    public RxBoolean(Boolean field) {
        super(field);
    }

    public void toggle() {
        set(!get());
    }

    public boolean TRUE() {
        return get();
    }

    public boolean FALSE() {
        return !get();
    }
}
