package com.chenps3.algs.chapter2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//插入排序
//输入越有序，插入排序越快
//最坏的情况，需要N2次比较和交换
//交换操作数=输入数组的倒置数
public class InsertSort {

    public static <T> void sort(Comparable<T>[] a) {
        for (int i = 1; i < a.length; i++) {
            //将a[i]插入到a[0]至a[i-1]中合适的位置
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static <T> void sortV2(Comparable<T>[] a) {
        for (int i = 1; i < a.length; i++) {
            //将a[i]插入到a[0]至a[i-1]中合适的位置
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                //todo 改进，一次exch要访问4次数组，可减少访问次数，将大元素右移一位而不交换
            }
        }
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    //一次exch
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
