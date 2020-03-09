package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 动态规划
 *
 * @Author chenguanhong
 * @Date 2020-03-09
 */
public class Problem121 {

    public static void main(String[] args) {

    }

    //a(i):第i天卖出的最大利润,b(i):第i天的价格
    //a(i) = a(i-1) + (b(i) - b(i-1))
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i - 1] + (prices[i] - prices[i - 1]);
            dp[i] = dp[i] > 0 ? dp[i] : 0;
        }
        int maxProfit = dp[0];
        for (int i = 1; i < dp.length; i++) {
            maxProfit = dp[i] > maxProfit ? dp[i] : maxProfit;
        }
        return maxProfit;
    }
}
