package com.chenps3.algs.leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 堆
 *
 * @Author chenguanhong
 * @Date 2020-02-09
 */
public class Problem215 {

    public int findKthLargest(int[] nums, int k) {
        heapSort(nums);
        return nums[k - 1];
    }

    //倒序排序
    private void heapSort(int[] nums) {
        //1 构建最小堆
        int n = nums.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(nums, k, n);
        }
        while (n > 0) {
            exch(nums, 1, n--);
            sink(nums, 1, n);
        }
    }

    private void sink(int[] nums, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && greater(nums, j, j + 1)) {
                j++;
            }
            if (!greater(nums, k, j)) {
                break;
            }
            exch(nums, j, k);
            k = j;
        }
    }

    private boolean greater(int[] nums, int i, int j) {
        return nums[i - 1] > nums[j - 1];
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i - 1];
        nums[i - 1] = nums[j - 1];
        nums[j - 1] = tmp;
    }
}
