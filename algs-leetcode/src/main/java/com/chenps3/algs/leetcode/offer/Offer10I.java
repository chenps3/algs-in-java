package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problemset/lcof/
 * 动态规划
 *
 * @Author chenguanhong
 * @Date 2020-03-07
 */
public class Offer10I {

    public static void main(String[] args) {
        System.out.println(fib(48));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
