package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * 二分
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer16 {

    public static void main(String[] args) {
        System.out.println(myPow(-1, -7));
    }

    public static double myPow(double x, int n) {
        if (x == 0.0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / powHelper(x, -1L * n);
        }
        return powHelper(x, n);
    }

    private static double powHelper(double x, long n) {
        if (n == 1) {
            return x;
        }
        double tmp = powHelper(x, n >>> 1);
        if (n % 2 == 0) {
            return tmp * tmp;
        } else {
            return tmp * tmp * x;
        }
    }
}
