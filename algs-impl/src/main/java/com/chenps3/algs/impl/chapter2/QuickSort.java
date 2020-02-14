package com.chenps3.algs.impl.chapter2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//快速排序
//原地排序，时间复杂度NLogN
public class QuickSort {

    public static <T> void sort(Comparable<T>[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static <T> void sort(Comparable<T>[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);        //切分
        sort(a, low, j - 1);                    //左半边排序
        sort(a, j + 1, high);                   //右半边排序
    }

    //三向切分（大于 等于 小于）快排
    //有大量重复元素时，性能接近O(n)
    private static <T> void sort3way(Comparable<T>[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int lt = low;       //lt左边的都小于v
        int i = low + 1;
        int gt = high;      //gt右边的都大于v
        Comparable<T> v = a[low];
        //扫描数组元素与v比较，小的放lt左边，大的放gt右边，相等的不变
        //目的是令 a[low...lt-1] < a[lt...gt] < a[gt+1,high]，lt和gt之间保存与v相等的元素
        while (i <= gt) {
            int cmp = a[i].compareTo((T) v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);       //这里只是为了把原a[i]放到最右边，i没变，下一轮会比较被换过来的元素
            } else {
                i++;
            }
        }
        sort3way(a, low, lt - 1);
        sort3way(a, gt + 1, high);
    }

    //切分,取a[low]作为切分值，小于a[low]的放到左边，大于a[low]的放到右边
    private static <T> int partition(Comparable<T>[] a, int low, int high) {
        int i = low;                //i从左扫描
        int j = high + 1;           //j从右
        Comparable<T> v = a[low];
        while (true) {
            //找到第一个a[i]满足 a[i]>=v 有助于处理含有大量重复值的情况
            while (less(a[++i], v)) {
                if (i == high) break;
            }
            //找到第一个a[j]满足 a[j]<v
            while (less(v, a[--j])) {
                if (j == low) break;        //其实是多余的，因为less(v, a[low])一定为false
            }
            //i>=j说明切分完成
            if (i >= j) break;
            //交换保证i左边的元素都小于v,j右边的元素都大于等于v
            exch(a, i, j);
        }
        exch(a, low, j);        //循环结束后，j右边的元素一定大于等于v，v的正确位置即为索引j
        return j;
    }

    //打乱
    private static <T> void shuffle(Comparable<T>[] a) {
        List list = Arrays.asList(a);
        Collections.shuffle(Arrays.asList(a));
        a = (Comparable<T>[]) list.toArray();
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
        //需要启用jvm配置 -ea
        assert isSorted(input);
        show(input);
    }
}
