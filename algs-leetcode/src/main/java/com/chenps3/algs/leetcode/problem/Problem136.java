package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/single-number/
 *
 * @Author chenguanhong
 * @Date 2020/5/14
 */
public class Problem136 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 1};
        System.out.println(singleNumber(nums));
    }

    //利用异或的性质
    public static int singleNumber(int[] nums) {
        int k = nums[0];
        for (int i = 1; i < nums.length; i++) {
            k ^= nums[i];
        }
        return k;
    }
}
