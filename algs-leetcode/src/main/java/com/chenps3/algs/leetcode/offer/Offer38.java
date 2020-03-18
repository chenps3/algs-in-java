package com.chenps3.algs.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/18
 */
public class Offer38 {

    public static void main(String[] args) {
        String[] ss = permutation("kzxx");
        System.out.println();
    }

    public static String[] permutation(String s) {
        helper(s.toCharArray(), 0);
        return new HashSet<>(list).toArray(new String[0]);
    }

    private static List<String> list = new ArrayList<>();

    private static void helper(char[] str, int lo) {
        if (lo == str.length) {
            list.add(new String(str));
        }
        for (int i = lo; i < str.length; i++) {
            exch(str, lo, i);
            helper(str, lo + 1);
            exch(str, lo, i);
        }
    }

    private static void exch(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
