package com.chenps3.algs.impl.chapter1;


public interface Stack<T> extends Iterable<T> {

    void push(T item);

    T pop();

    boolean isEmpty();

    int size();
}
