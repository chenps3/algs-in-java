package com.chenps3.algs.leetcode.offer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/4/29
 */
public class Offer40 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int[] a = getLeastNumbers(arr, 2);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        int p = partition(arr, lo, hi);
        while (p != k - 1) {
            if (p > k - 1) {
                hi = p - 1;
            } else if (p < k - 1) {
                lo = p + 1;
            }
            p = partition(arr, lo, hi);
        }
        return Arrays.copyOf(arr, k);
    }

    private static int partition(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return hi;
        }
        int i = lo;
        int j = hi + 1;
        int v = arr[lo];
        while (true) {
            while (arr[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (v < arr[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
