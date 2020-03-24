package com.chenps3.algs.impl.quicksort;

import java.util.WeakHashMap;

/**
 * 快排
 *
 * @Author chenguanhong
 * @Date 2020/3/20
 */
public class Quick {

    public static void quickSort(Comparable[] a) {

    }

    private static void quickSort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int k = partition(a, lo, hi);
        quickSort(a, lo, k - 1);
        quickSort(a, k + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
