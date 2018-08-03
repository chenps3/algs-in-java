package com.chenps3.algs.chapter2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//希尔排序
//基于插入排序【倒置数越少，性能越好】的特点
//基本思想：先令数组中任意间隔为h的元素是有序的，每轮排序后，h越来越小，当h为1时数组整体有序了
//下列算法使用序列 1/2(3k-1)，从N/3到1
public class ShellSort {

    public static <T> void sort(Comparable<T>[] a) {
        //实现
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <T> void show(Comparable<T>[] a) {
        for (Comparable<T> item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static <T> boolean isSorted(Comparable<T>[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    private static String[] input() {
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String filePath = classpath + File.separator + "sort1.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String data = reader.readLine();
            return data.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String[] input = input();
        show(input);
        sort(input);
        assert isSorted(input);
        show(input);
    }
}
