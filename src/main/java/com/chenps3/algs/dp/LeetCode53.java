package com.chenps3.algs.dp;

public class LeetCode53 {

    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(input));
    }

    private static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i] >= nums[i] ? dp[i - 1] + nums[i] : nums[i];
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = dp[i] >= max ? dp[i] : max;
        }
        return max;
    }
}
