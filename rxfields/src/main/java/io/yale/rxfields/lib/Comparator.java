package io.yale.rxfields.lib;

/**
 * Created by YaleZheng on 2016/12/4.
 */

public interface Comparator<T> {
    boolean isEqual(T lhs, T rhs);
}
