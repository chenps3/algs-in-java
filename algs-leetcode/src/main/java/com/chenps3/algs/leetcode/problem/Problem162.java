package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-25
 */
public class Problem162 {

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 1};
        int[] n2 = {1, 2, 1, 3, 5, 6, 4};

        int p1 = findPeakElement(n1);
        int p2 = findPeakElement(n2);
        System.out.println(p1 == 2);
        System.out.println(p2 == 1 || p2 == 5);
    }

    //返回极大值的下标
    //在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
    public static int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;       //有mid+1，防止溢出
        //左闭右开，不断向左逼近
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            //极大值在mid左边
            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            }
            //极大值在mid右边
            else if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            }
            //不可能相等
            else {
                return -1;
            }
        }
        return lo;
    }
}
