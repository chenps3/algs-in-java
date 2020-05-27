package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * @Author chenguanhong
 * @Date 2020/5/12
 */
public class Problem155 {

    public static void main(String[] args) {
        Problem155 minStack = new Problem155();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    int[] stackArray;
    int topIndex;
    int[] minArray;
    int minIndex;

    public Problem155() {
        stackArray = new int[10];
        minArray = new int[10];
        topIndex = -1;
        minIndex = -1;
    }

    public void push(int x) {
        if(topIndex == stackArray.length-1){
            resizeStackArray(2 * stackArray.length);
        }
        stackArray[++topIndex] = x;
        if(minIndex==-1 || x < minArray[minIndex]){
            if(minIndex == minArray.length-1){
                resizeMinArray(2 * minArray.length);
            }
            minArray[++minIndex] = x;
        }
    }

    public void pop() {
        int top = stackArray[topIndex];
        topIndex--;
        if(top == minArray[minIndex]){
            minIndex--;
        }
    }

    public int top() {
        return stackArray[topIndex];
    }

    public int getMin() {
        return minArray[minIndex];
    }

    void resizeStackArray(int capacity){
        int[] tmp = new int[capacity];
        for(int i = 0;i < stackArray.length;i++){
            tmp[i] = stackArray[i];
        }
        stackArray = tmp;
    }

    void resizeMinArray(int capacity){
        int[] tmp = new int[capacity];
        for(int i = 0;i < minArray.length;i++){
            tmp[i] = minArray[i];
        }
        minArray = tmp;
    }
}
