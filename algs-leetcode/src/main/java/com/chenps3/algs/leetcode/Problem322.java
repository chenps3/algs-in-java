package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 动态规划
 *
 * @Author chenguanhong
 * @Date 2020-03-08
 */
public class Problem322 {

    public static void main(String[] args) {
        int[] c = {1, 2, 5};
        System.out.println(coinChange(c, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;     //理论上最大值为amount
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int money = coins[j];
                if (i >= money) {
                    dp[i] = min(dp[i], 1 + dp[i - money]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

}
