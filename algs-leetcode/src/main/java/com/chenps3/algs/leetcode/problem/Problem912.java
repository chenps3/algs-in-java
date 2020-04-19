package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 * 快速排序
 * 归并排序
 *
 * @Author chenguanhong
 * @Date 2020/3/31
 */
public class Problem912 {

    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = sortArray(a);
        System.out.println(b);
    }

    public static int[] sortArray(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

//法3：归并排序排序------------------------------------------------------------------------------------------------------

    private static void mergeSort(int[] a) {

    }

//法2：三向切分的快速排序-------------------------------------------------------------------------------------------------

    private static void quick3Way(int[] a, int lo, int hi) {
        int lt = lo;
        int gt = hi;
        int i = lo + 1;
        int v = a[lo];
        while (i <= gt) {
            if (a[i] < v) {
                exch(a, i, lt);
                ++lt;
                ++i;
            } else if (a[i] > v) {
                exch(a, i, gt);
                --gt;
            } else {
                ++i;
            }
        }
        quick3Way(a, lo, lt - 1);
        quick3Way(a, gt + 1, hi);
    }

//法1：快速排序+插入排序--------------------------------------------------------------------------------------------------

    private static void insertSort(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void qSort(int[] a, int lo, int hi) {
        if (lo + 8 >= hi) {
            insertSort(a, lo, hi);
            return;
        }
        int k = partition(a, lo, hi);
        qSort(a, lo, k - 1);
        qSort(a, k + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int k = a[lo];
        int i = lo + 1;
        int j = hi;
        while (true) {
            while (less(a[i], k)) {
                ++i;
                if (i == hi) {
                    break;
                }
            }
            while (less(k, a[j])) {
                --j;
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

    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
