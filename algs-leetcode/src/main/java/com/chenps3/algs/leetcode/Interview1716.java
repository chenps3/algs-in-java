package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 *
 * @Author chenguanhong
 * @Date 2020/3/24
 */
public class Interview1716 {

    public static void main(String[] args) {
        int[] a1 = {2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(massage(a1));
    }

    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            int k = dp[i - 2];
            if (i - 3 >= 0) {
                k = Math.max(dp[i - 3], k);
            }
            dp[i] = nums[i] + k;
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
