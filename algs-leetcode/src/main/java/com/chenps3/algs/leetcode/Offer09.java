package com.chenps3.algs.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * <p>
 * 栈
 * 队列
 *
 * @Author chenguanhong
 * @Date 2020-03-07
 */
public class Offer09 {

    public static void main(String[] args) {
        Offer09 queue = new Offer09();
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    public Offer09() {

    }

    public void appendTail(int value) {
        s2.push(value);
    }

    public int deleteHead() {
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        if(!s1.isEmpty()){
            return s1.pop();
        }
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return s1.pop();
    }

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
}
