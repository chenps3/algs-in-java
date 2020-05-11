package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 简单动态规划
 * @Author chenguanhong
 * @Date 2020/5/3
 */
public class Problem53 {

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(a));
    }

    //dp[i]: 以nums[i]结尾的子序列的最大和
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
