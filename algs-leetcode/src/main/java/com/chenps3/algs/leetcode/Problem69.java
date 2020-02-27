package com.chenps3.algs.leetcode;

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
        System.out.println(mySqrt(2));

    }

    public static int mySqrt(int x) {
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
}
