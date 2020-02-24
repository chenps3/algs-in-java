package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * <p>
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-23
 */
public class Problem33 {

    public static void main(String[] args) {
        int nums[] = {3, 1};
        System.out.println(findMin(nums));
        System.out.println(search(nums, 1));
    }

    //解法1，找到最小点，再二分
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        boolean rotate = nums[0] > nums[nums.length - 1];
        int lo = 0;
        int hi = nums.length - 1;
        if (rotate) {
            boolean leftHalf = target >= nums[0];
            int minIndex = findMin(nums);
            lo = leftHalf ? 0 : minIndex;
            hi = leftHalf ? minIndex - 1 : nums.length - 1;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static int findMin(int[] nums) {
        int left = nums[0];
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //mid在左数组
            if (nums[mid] >= left) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid + 1;
                }
                lo = mid + 1;
            }
            //mid在右数组
            else if (nums[mid] < left) {
                if (nums[mid] < nums[mid - 1]) {
                    return mid;
                }
                hi = mid - 1;
            }
        }
        return -1;
    }


    //解法2，不用找最小点
    public static int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int left = nums[lo];
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //前半部分有序
            if (left <= nums[mid]) {
                //target在前半部分
                if (target <= nums[mid] && target >= left) {
                    hi = mid - 1;
                }
                //否则一定在后半部分
                else {
                    lo = mid + 1;
                }
            }
            //后半部分有序
            else if (left > nums[mid]) {
                //target在后半部分
                if (target > nums[mid] && target < left) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
