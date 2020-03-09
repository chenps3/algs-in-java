package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 动态规划
 * 贪心
 *
 * @Author chenguanhong
 * @Date 2020-03-09
 */
public class Offer14I {

    public static void main(String[] args) {
        System.out.println(cuttingRopeV1(4));
    }

    //法1：动态规划
    //f(i) = max(max(j*(i-j),j*dp[i-j])),1<=j<=i-1
    public static int cuttingRopeV1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    //法2：贪心
    //见Offer14II
    public static int cuttingRopeV2(int n) {
        return 1;
    }
}
