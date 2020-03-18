package com.chenps3.algs.leetcode.offer;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * 栈
 *
 * @Author chenguanhong
 * @Date 2020/3/12
 */
public class Offer31 {

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped1 = {4, 5, 3, 2, 1};
        int[] poped2 = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(pushed, poped1));
        System.out.println(validateStackSequences(pushed, poped2));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                ++j;
            }
        }
        return stack.isEmpty();
    }
}
