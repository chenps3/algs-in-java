package com.chenps3.algs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

public class FixedCapacityStack<T> implements Stack<T> {

    public FixedCapacityStack(int cap) {
        a = (T[]) new Object[cap];
    }

    @Override
    public void push(T item) {
        if(a.length == N){
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    @Override
    public T pop() {
        T item = a[--N];
        a[N] = null;
        if(N > 0 && N == a.length / 4){
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private void resize(int max){
        T[] tmp =(T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    private T[] a;
    private int N;

    public static void main(String[] args) throws Exception{
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        String path = FixedCapacityStackOfStrings.class.getResource("/").getPath() + "tobe.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
            String tmp[] = s.split(" ");
            for(String ss : tmp){
                if(!ss.equals("-")){
                    stack.push(ss);
                }else if(!stack.isEmpty()){
                    System.out.println(stack.pop() + " ");
                }
            }
        }
        System.out.println(stack.size() + "left on stack");
        bufferedReader.close();
    }
}
