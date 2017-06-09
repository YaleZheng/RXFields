package io.yale.rxfields.lib;

import java.util.Arrays;
import java.util.Comparator;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by yalez on 2016/12/1.
 */

public class RxArray<T> {
    private T[] array;
    private PublishSubject<Opt<T[]>> subject = PublishSubject.create();

    public RxArray(T[] array) {
        this.array = array;
    }

    public void set(int idx, T value) {
        if (idx >= 0 && idx < this.array.length) {
            this.array[idx] = value;
        }
    }

    public T get(int idx) {
        if (idx >= 0 && idx < this.array.length) {
            return this.array[idx];
        }
        return null;
    }

    public T[] get() {
        return Arrays.copyOf(array, array.length);
    }

    public void reset(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
        subject.onNext(new Opt<>(this.array));
    }

    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    public int indexOf(T item) {
        return Arrays.binarySearch(this.array, item);
    }

    public boolean isEmpty() {
        return this.array.length == 0;
    }

    public int size() {
        return this.array.length;
    }

    public void sort(Comparator<T> comparator) {
        Arrays.sort(this.array, comparator);
        subject.onNext(new Opt<>(this.array));
    }

    public Observable<Opt<T[]>> ob() {
        return Observable.merge(Observable.just(new Opt<>(array)), subject);
    }
}
