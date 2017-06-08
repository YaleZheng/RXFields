package io.yale.rxfields.lib;



/**
 * Created by yalez on 2016/12/1.
 */

public class RxFloat extends RxField<Float> {

    public RxFloat() {
        super(0F);
    }

    public RxFloat(Float field) {
        super(field);
    }

    public void add(float value) {
        set(get() + value);
    }
}
