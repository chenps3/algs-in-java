package com.chenps3.algs.impl.quicksort;

/**
 * @Author chenguanhong
 * @Date 2020/3/20
 */
public class Insertion {

    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = 2;
        swap(i1, i2);
        System.out.println();
    }

    private static void swap(Integer i1, Integer i2) {
        Integer tmp = i1;
        i1 = i2;
        i2 = tmp;
    }

    public static void sort(Comparable[] a, int lo, int hi) {
//        for (int i = lo + 1; i <= hi; i++) {
//            for (int j = i; j >; j++) {
//
//            }
//        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
