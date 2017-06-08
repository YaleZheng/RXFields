package io.yale.rxfields.lib;

import java.util.ResourceBundle;

/**
 * Created by yalez on 2017/6/8.
 */

public class Opt<T> {
    private T value;

    public Opt(T value) {
        this.value = value;
    }

    public T get() {
        if (this.value == null) {
            throw new AssertionError("argument must not be null");
        }
        return this.value;
    }

    public T or(T def) {
        return this.value == null ? def : this.value;
    }

    public T orNull() {
        return this.value;
    }
}
