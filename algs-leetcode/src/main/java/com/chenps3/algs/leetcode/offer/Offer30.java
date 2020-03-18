package com.chenps3.algs.leetcode.offer;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/12
 */
public class Offer30 {

    public static void main(String[] args) {
        Offer30 minStack = new Offer30();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }

    int[] arr;
    int top;
    Stack<Integer> minStack; //保存下标

    public Offer30() {
        arr = new int[10];
        top = -1;
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (top == arr.length - 1) {
            resize(2 * arr.length);
        }
        arr[++top] = x;
        if (minStack.isEmpty() || x < arr[minStack.peek()]) {
            minStack.push(top);
        }
    }

    public void pop() {
        if (top < 0) {
            return;
        }
        if (top == minStack.peek()) {
            minStack.pop();
        }
        --top;
    }

    public int top() {
        if (top >= 0) {
            return arr[top];
        }
        return -1;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return arr[minStack.peek()];
    }

    private void resize(int capacity) {
        int[] tmp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
    }
}
