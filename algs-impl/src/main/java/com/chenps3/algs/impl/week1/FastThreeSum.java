package com.chenps3.algs.impl.week1;

import java.util.Arrays;

/**
 * N2级别的快速算法，基于排序&二分法
 */
public class FastThreeSum {

    public static int fastThreeSum(int[] a) {
        //排序
        Arrays.sort(a);
        int length = a.length;
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            //从两端遍历
            for (int j = i + 1, k = length - 1; j < k; ) {
                if (a[j] + a[k] < 0 - a[i]) {
                    ++j;
                } else if (a[j] + a[k] > 0 - a[i]) {
                    --k;
                } else {
                    ++cnt;
                    ++j;
                    --k;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println(fastThreeSum(a));
    }
}
