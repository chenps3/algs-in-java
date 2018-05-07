package com.chenps3.algs.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/description/
 * 最优解：使用hash表存储，一次遍历
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] x = twoSum(nums, target);
        for (int i : x) {
            System.out.println(i);
        }
        Arrays.sort(nums);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
