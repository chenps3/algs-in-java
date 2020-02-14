package com.chenps3.algs.impl.dp;

/**
 * f[i]：最后一个阶梯是cost[i]时的总花费
 * f[i] = min (f[i-1]+a[i],f[i-2]+a[i])
 */
public class LeetCode746 {

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] fun = new int[cost.length];
        fun[0] = cost[0];
        fun[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            fun[i] = min(fun[i - 1] + cost[i], fun[i - 2] + cost[i]);
        }
        return min(fun[cost.length - 1], fun[cost.length - 2]);
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
