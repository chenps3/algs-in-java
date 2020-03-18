package com.chenps3.algs.leetcode.offer;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * @Author chenguanhong
 * @Date 2020-03-07
 */
public class Offer59II {

    public static void main(String[] args) {
        Offer59II m = new Offer59II();
        m.push_back(1);
        m.push_back(2);
        System.out.println(m.max_value());
        System.out.println(m.pop_front());
        System.out.println(m.pop_front());
    }

    public Offer59II() {
        currIndex = 0;
        data = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) {
            return -1;
        }
        return max.getFirst().val;
    }

    public void push_back(int value) {
        //后进的元素A如果比前面的元素都大，A之前的元素无论怎么pop，max都是A
        while (!max.isEmpty() && value >= max.getLast().val) {
            max.removeLast();
        }
        InternalData i = new InternalData(currIndex, value);
        data.addLast(i);
        max.addLast(i);
        currIndex++;
    }

    public int pop_front() {
        if (max.isEmpty()) {
            return -1;
        }
        //说明max被pop出去了
        if (max.getFirst().index == data.getFirst().index) {
            max.removeFirst();
        }
        return data.removeFirst().val;
    }

    private static class InternalData {
        private int index;
        private int val;

        public InternalData(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    private LinkedList<InternalData> data;
    private LinkedList<InternalData> max;
    private int currIndex;

}
