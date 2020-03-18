package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * <p>
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-24
 */
public class Problem50 {

    public static void main(String[] args) {
        double a1 = myPow(2.0, 10);
        System.out.println(a1 == 1024.0);

        double a2 = myPow(2.1, 3);
        System.out.println(a2 == 9.261);

        double a3 = myPow(2.0, -2);
        System.out.println(a3 == 0.25);

        double a4 = myPow(8.95371, -1);
        System.out.println(a4 == 0.11169);
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        long m = n > 0 ? n : -1L * n;
        double tmp;
        double power = myPow(x, (int) (m / 2));
        if (n % 2 == 0) {
            tmp = power * power;
        } else {
            tmp = power * power * x;
        }
        return n > 0 ? tmp : 1 / tmp;
    }


}
