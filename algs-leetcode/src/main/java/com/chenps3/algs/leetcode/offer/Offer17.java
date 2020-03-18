package com.chenps3.algs.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer17 {

    public int[] printNumbers(int n) {
        int max = getMax(n);
        int[] a = new int[max];
        for (int i = 1; i <= max; i++) {
            a[i - 1] = i;
        }
        return a;
    }

    private int getMax(int n) {
        int max = 1;
        while (n-- > 0) {
            max *= 10;
        }
        return max - 1;
    }
}
