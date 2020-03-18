package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-25
 */
public class Problem81 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int[] nums1 = {3, 1, 1};
        int[] nums3 = {1, 3, 5};

        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
        System.out.println(search(nums1, 3));
        System.out.println(search(nums3, 1));
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int left = nums[lo];
            if (target == nums[mid]) {
                return true;
            }
            //不确定哪边有序
            if (left == nums[mid]) {
                lo++;
            }
            //左半部分有序
            if (left < nums[mid]) {
                if (target < nums[mid] && target >= left) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            //右半部分有序
            if (left > nums[mid]) {
                if (target > nums[mid] && target < left) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        }
        return false;
    }
}
