package com.chenps3.algs.leetcode;

import com.chenps3.algs.leetcode.problem.Problem21;

/**
 * 习题重做
 *
 * @Author chenguanhong
 * @Date 2020/5/1
 */
public class Review {

    public static void main(String[] args) {
        System.out.println(myPow(2.0, -2));
    }

    public static double myPow(double x, int n) {
        if (x == 0.0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int k = Math.abs(n);
        int t = 1;
        double y = x;
        while (t != k) {
            if (t * 2 <= k) {
                t = t * 2;
                y = y * y;
            } else {
                t = t + 1;
                y = y * x;
            }
        }
        return n > 0 ? y : 1 / y;
    }
}
