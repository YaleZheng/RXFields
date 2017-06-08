package io.yale.rxfields.lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by yalez on 2016/12/1.
 */

public class RxList<T> {
    private List<T> list;
    private PublishProcessor<Opt<List<T>>> subject = PublishProcessor.create();

    public RxList(List<T> list) {
        this.list = (list == null) ? new LinkedList<T>() : list;
    }

    public void reset(T item) {
        this.list.clear();
        this.list.add(item);
        subject.onNext(new Opt<>(this.list));
    }

    public void reset(Collection<? extends T> collection) {
        this.list.clear();
        this.list.addAll(collection);
        subject.onNext(new Opt<>(this.list));
    }

    public void add(T item) {
        this.list.add(item);
        subject.onNext(new Opt<>(this.list));
    }

    public void add(int idx, T item) {
        this.list.add(idx, item);
        subject.onNext(new Opt<>(this.list));
    }

    public void addAll(Collection<? extends T> collection) {
        this.list.addAll(collection);
        subject.onNext(new Opt<>(this.list));
    }

    public void addAll(int position, Collection<? extends T> collection) {
        this.list.addAll(position, collection);
        subject.onNext(new Opt<>(this.list));
    }

    public void remove(T item) {
        if (this.list.contains(item)) {
            this.list.remove(item);
            subject.onNext(new Opt<>(this.list));
        }
    }

    public void remove(int idx) {
        if (idx >= 0 && idx < this.list.size()) {
            this.list.remove(idx);
            subject.onNext(new Opt<>(this.list));
        }
    }

    public void removeAll(Collection<? extends T> collection) {
        this.list.removeAll(collection);
        subject.onNext(new Opt<>(this.list));
    }

    public void clear() {
        this.list.clear();
        subject.onNext(new Opt<>(this.list));
    }

    public boolean contains(T item) {
        return this.list.contains(item);
    }

    public int indexOf(T item) {
        return this.list.indexOf(item);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public void sort(Comparator<T> comparator) {
        Collections.sort(this.list, comparator);
        subject.onNext(new Opt<>(this.list));
    }

    public List<T> get() {
        return new ArrayList<>(this.list);
    }

    public Flowable<Opt<List<T>>> ob() {
        return Flowable.merge(Flowable.just(new Opt<>(list)), subject);
    }
}
