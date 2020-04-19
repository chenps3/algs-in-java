package com.chenps3.algs.leetcode.problem;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @Author chenguanhong
 * @Date 2020/3/26
 */
public class Problem146 {

    public Problem146(int capacity) {
        hashMap = new HashMap<>();
        linkedList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }

    private LinkedList<Integer> linkedList;

    private HashMap<Integer, Integer> hashMap;

    private int capacity;

    private static class CacheNode{

    }

}
