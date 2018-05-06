package com.chenps3.algs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

public class ResizingArrayStack<T> implements Stack<T> {

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
        return new Iterator<T>() {
            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                return a[--i];
            }
        };
    }

    private void resize(int max){
        T[] tmp =(T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    private T[] a = (T[]) new Object[1];
    private int N = 0;

    public static void main(String[] args) throws Exception{
        testCase2();
    }

    static void testCase1() throws Exception{
        String path = ResizingArrayStack.class.getResource("/").getPath() + "tobe.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            ResizingArrayStack<String> stack = new ResizingArrayStack<>();
            System.out.println(s);
            String tmp[] = s.split(" ");
            for(String ss : tmp){
                if(!ss.equals("-")){
                    stack.push(ss);
                }else if(!stack.isEmpty()){
                    System.out.print(stack.pop() + " ");
                }
            }
            System.out.println();
            System.out.println(stack.size() + " left on stack:");
            for(String left : stack){
                System.out.println(left);
            }
        }
        bufferedReader.close();
    }

    //exe 1.3.4
    static void testCase2(){
        boolean result = true;
        String input = "[(])";
        char[] cs = input.toCharArray();
        Stack<Character> stack = new ResizingArrayStack<>();
        for(char c : cs){
            switch (c){
                case '{':
                    stack.push(c);break;
                case '[':
                    stack.push(c);break;
                case '(':
                    stack.push(c);break;
                case ')':
                    if(stack.pop()!='('){
                        result = false;
                    }
                    break;
                case ']':
                    if(stack.pop()!='['){
                        result = false;
                    }
                    break;
                case '}':
                    if(stack.pop()!='{'){
                        result = false;
                    }
                    break;
            }
        }
        System.out.println(result);
    }

}
