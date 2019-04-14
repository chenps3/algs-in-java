package com.chenps3.algs.dp;

public class LeetCode121 {

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9};
        System.out.println(maxProfit(input));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
            dp[i] = dp[i] > 0 ? dp[i] : 0;
        }
        int maxProfit = dp[0];
        for (int i = 1; i < dp.length; i++) {
            maxProfit = dp[i] > maxProfit ? dp[i] : maxProfit;
        }
        return maxProfit;
    }
}
