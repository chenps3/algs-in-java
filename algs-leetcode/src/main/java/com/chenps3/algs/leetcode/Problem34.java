package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 二分查找的两侧边界
 *
 * @Author chenguanhong
 * @Date 2020-02-24
 */
public class Problem34 {

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int[] a1 = searchRange(nums, 3);
        System.out.println(a1[0]);
        System.out.println(a1[1]);
        System.out.println();
//        int[] a2 = searchRange(nums, 6);
//        System.out.println(a2[0]);
//        System.out.println(a2[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchLeft(nums, target);
        result[1] = searchRight(nums, target);
        return result;
    }

    //左侧边界
    public static int searchLeft(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                hi = mid;
            } else if (target < nums[mid]) {
                hi = mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            }
        }
        if (lo == nums.length) {
            return -1;
        }
        return nums[lo] == target ? lo : -1;
    }

    //右侧边界
    public static int searchRight(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                lo = mid + 1;
            } else if (target < nums[mid]) {
                hi = mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            }
        }
        if (lo == 0) {
            return -1;
        }
        return nums[lo - 1] == target ? lo - 1 : -1;
    }
}
