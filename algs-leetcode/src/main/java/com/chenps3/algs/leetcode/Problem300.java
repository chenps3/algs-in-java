package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-03-01
 */
public class Problem300 {

    public static void main(String[] args) {
        int[] n1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(n1) == 4);

        int[] n2 = {4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLIS(n2) == 3);

        int[] n3 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(n3) == 6);
    }

    public static int lengthOfLIS(int[] nums) {
        return s1(nums);
    }

    //法1：动态规划O(n²)
    public static int s1(int[] nums) {
        //dp[i]表示以元素nums[i]结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[j] + 1, dp[i]);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = max(result, dp[i]);
        }
        return result;
    }

    private static int max(int a1, int a2) {
        return a1 > a2 ? a1 : a2;
    }
}
