package com.chenps3.algs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

public class LinkedStack<T> implements Stack<T>{

    @Override
    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node curr = first;

            @Override
            public boolean hasNext() {
                return curr!=null;
            }

            @Override
            public T next() {
                T item = curr.item;
                curr = curr.next;
                return item;
            }
        };
    }

    private Node first;
    private int N;

    private class Node{
        T item;
        Node next;
    }

    public static void main(String[] args) throws Exception{
        LinkedStack<String> stack = new LinkedStack<>();
        String path = LinkedStack.class.getResource("/").getPath() + "tobe.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
            String tmp[] = s.split(" ");
            for(String ss : tmp){
                if(!ss.equals("-")){
                    stack.push(ss);
                }else if(!stack.isEmpty()){
                    System.out.print(stack.pop() + " ");
                }
            }
        }
        System.out.println("\n" + stack.size() + " left on stack:");
        for(String left : stack){
            System.out.println(left);
        }
        bufferedReader.close();
    }
}


