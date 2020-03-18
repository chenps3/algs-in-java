package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-24
 */
public class Problem35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5) == 2);
        System.out.println(searchInsert(nums, 2) == 1);
        System.out.println(searchInsert(nums, 7) == 4);
        System.out.println(searchInsert(nums, 0) == 0);
        int[] n1 = {1, 3};
        System.out.println(searchInsert(n1, 2) == 1);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                if (mid == nums.length - 1) {
                    return nums.length;
                }
                if (nums[mid + 1] > target) {
                    return mid + 1;
                }
                lo = mid + 1;
            } else if (target < nums[mid]) {
                if (mid == 0) {
                    return mid;
                }
                if (nums[mid - 1] < target) {
                    return mid;
                }
                hi = mid - 1;
            }
        }
        return 0;
    }
}
