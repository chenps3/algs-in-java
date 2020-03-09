package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 动态规划
 * 贪心
 * @Author chenguanhong
 * @Date 2020-03-09
 */
public class Offer14I {

    public static void main(String[] args) {
        System.out.println(cuttingRope(4));
    }

    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 2; i <= n; i++) {
            int max = dp[1];
            for (int j = 1; j < i; j++) {
                int tmp = j * dp[i - j];
                max = tmp > max ? tmp : max;
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
