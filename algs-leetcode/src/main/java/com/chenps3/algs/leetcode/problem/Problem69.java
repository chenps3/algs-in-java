package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * 二分查找
 * 牛顿法
 *
 * @Author chenguanhong
 * @Date 2020-02-25
 */
public class Problem69 {

    public static void main(String[] args) {
//        int a1 = mySqrt(4);
//        System.out.println(a1 == 2);
//        int a2 = mySqrt(8);
//        System.out.println(a2 == 2);
        System.out.println(mySqrt3(4));

    }

    //二分法
    public static int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int lo = 0;
        int hi = x;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                hi = mid - 1;
            } else if (square < x) {
                lo = mid + 1;
            }
        }
        return hi;
    }


    //牛顿法,这个是整数版本，准确的应该用double，见mySqrt3
    //https://www.zhihu.com/question/20690553/answer/543620219
    public static int mySqrt2(int x) {
        int t = 1;
        while (t - x / t != 0) {
            t = (t + x / t) / 2;
        }
        return t;
    }


    public static double mySqrt3(int x) {
        double eps = 1e-12;
        double t = x;
        while (Math.abs(t - x / t) > eps) {     //double数值精度问题
            t = (t + x / t) / 2;
        }
        return t;
    }
}
