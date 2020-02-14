package com.chenps3.algs.impl.ch1;

import java.util.TreeSet;

/**
 * 编程珠玑第1章习题1
 * 使用语言内置的库实现排序
 * JDK TreeSet自带排序
 */
public class One1 {

    public static void main(String[] args) {
        TreeSet<Integer> treeset = new TreeSet<>();
        treeset.add(3);
        treeset.add(1);
        treeset.add(2);
        System.out.println(treeset);
    }
}
