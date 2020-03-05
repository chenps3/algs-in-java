package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-29
 */
public class Problem287 {

    public static void main(String[] args) {
        int[] n1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(n1) == 2);

        int[] n2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(n2) == 3);
    }


    public static int findDuplicate(int[] nums) {
        return s1(nums);
    }

    //二分查找
    //数值范围是1到n，对1到n进行二分，遍历比较小于等于mid的数的个数cnt
    //如果cnt<=mid,重复的数一定大于mid，否则重复的数小于等于mid
    //重复logn次
    private static int s1(int[] nums) {
        int lo = 1;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


}
