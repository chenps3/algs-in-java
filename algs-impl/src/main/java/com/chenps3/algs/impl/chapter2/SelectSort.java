package com.chenps3.algs.impl.chapter2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//选择排序
//需要N次交换，1+2+..+(N-1)次比较
//特点：1）运行时间与输入无关 2）数据移动最少
public class SelectSort {
    public static <T> void sort(Comparable<T>[] a) {
        if (a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            //最小元素索引，初始化为i
            int min = i;
            //找出a[i]到a[a.length]中最小的元素的索引min
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            //a[i]与a[i+1...a.length]中最小的元素交换
            exch(a, i, min);
        }
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
