package com.chenps3.algs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

public class LinkedQueue<T> implements Iterable<T> {

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node curr = head.next;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T item = curr.item;
                curr = curr.next;
                return item;
            }
        };
    }

    public LinkedQueue() {
        head = new Node();      //加一个头结点，就不用判断null了
        tail = head;
    }

    //从队尾添加
    public void enqueue(T item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        oldTail.next = tail;
        N++;
    }

    //从队头删除
    public T dequeue() {
        Node node = head.next;
        head.next = head.next.next;
        N--;
        return node.item;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public int size() {
        return N;
    }

    private class Node {
        T item;
        Node next;
    }

    private Node head;
    private Node tail;
    private int N;

    public static void main(String[] args) throws Exception {
        LinkedQueue<String> queue = new LinkedQueue<>();
        String path = LinkedQueue.class.getResource("/").getPath() + "tobe.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
            String tmp[] = s.split(" ");
            for (String ss : tmp) {
                if (!ss.equals("-")) {
                    queue.enqueue(ss);
                } else if (!queue.isEmpty()) {
                    System.out.print(queue.dequeue() + " ");
                }
            }
        }
        System.out.println("\n" + queue.size() + " left on queue:");
        for (String left : queue) {
            System.out.println(left);
        }
        bufferedReader.close();
    }
}
