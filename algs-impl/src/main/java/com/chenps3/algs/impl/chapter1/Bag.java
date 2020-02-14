package com.chenps3.algs.impl.chapter1;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

    private Node head = new Node();

    public void add(T item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
    }

    public boolean isEmpty() {
        //todo
        return false;
    }

    public int size() {
        //todo
        return 0;
    }

    public Iterator<T> iterator() {
        return null;
    }

    private class Node {
        T item;
        Node next;
    }
}
