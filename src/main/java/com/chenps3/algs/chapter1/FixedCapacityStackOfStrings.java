package com.chenps3.algs.chapter1;

import java.io.*;

public class FixedCapacityStackOfStrings {

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean isFull(){
        return N == a.length;
    }

    private String[] a;
    private int N;

    public static void main(String[] args) throws Exception {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
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
