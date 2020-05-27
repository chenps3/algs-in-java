package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/missing-number/
 * @Author chenguanhong
 * @Date 2020/5/14
 */
public class Problem268 {

    //不缺少数字情况下的和 - 缺少数字情况下的和
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int guessSum = (0 + n) * (n+1)/2;
        int realSum = 0;
        for(int i = 0;i < n;i++){
            realSum += nums[i];
        }
        return guessSum-realSum;
    }
}
