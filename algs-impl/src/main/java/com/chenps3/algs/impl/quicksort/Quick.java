package com.chenps3.algs.impl.quicksort;

/**
 * 快排
 * 改进1：切换插入排序
 * 改进2：
 *
 * @Author chenguanhong
 * @Date 2020/3/20
 */
public class Quick {

    public static void quickSort(Comparable[] a) {

    }

    private static int M = 8;

    //性能优化
    //1 转为插入排序
    //2 三向切分
    private static void qSortBetter(Comparable[] a, int lo, int hi) {
        if (lo + M >= hi) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt, i);
                ++lt;
                ++i;
            } else if (cmp > 0) {
                exch(a, gt, i);
                --gt;
            } else if (cmp == 0) {
                ++i;
            }
        }
        qSortBetter(a, lo, lt - 1);
        qSortBetter(a, gt + 1, i);
    }

    //基本快排实现
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
