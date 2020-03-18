package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-25
 */
public class Problem153 {

    public static void main(String[] args) {
        int[] n1 = {3, 4, 5, 1, 2};
        int[] n2 = {4, 5, 6, 7, 0, 1, 2};
        int[] n3 = {1, 2, 3};

        System.out.println(findMin(n1) == 1);
        System.out.println(findMin(n2) == 0);
        System.out.println(findMin(n3) == 1);
    }

    //找出最小的元素，假设不重复
    public static int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int lo = 0;
        int hi = nums.length - 1;
        //没有旋转或只有一个元素
        if (nums[lo] <= nums[hi]) {
            return nums[lo];
        }
        int left = nums[0];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            //mid位于右边的有序数组，向左搜索
            if (nums[mid] < left) {
                hi = mid - 1;
            }
            //mid位于左边的有序数组，向右搜索
            else if (nums[mid] >= left) {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
