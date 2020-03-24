package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 *
 * @Author chenguanhong
 * @Date 2020/3/23
 */
public class Problem365 {

    public static void main(String[] args) {
//        System.out.println(canMeasureWater(3, 5, 4));
//        System.out.println(canMeasureWater(0, 2, 1));
        System.out.println(canMeasureWater(2, 6, 5));

    }

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == x || z == y) {
            return true;
        }
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        int k = max - min;
        if (z % k == 0) {
            return true;
        }
        while (k > 0 && min > 0) {
            if (z % k == 0) {
                return true;
            }
            k = Math.max(min, k) - Math.min(min, k);
        }
        return false;
    }
}
