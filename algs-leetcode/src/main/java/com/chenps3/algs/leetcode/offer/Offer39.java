package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/4/28
 */
public class Offer39 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    /**
     * 法1，用map记录出现次数，见169
     * 法2，转为top k问题，第n/2大的元素(partition后下标为n/2)一定是目标元素
     */
    public static int majorityElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int n = nums.length;
        int k = partition(nums, lo, hi);
        while (k != n / 2) {
            if (k < n / 2) {
                lo = k + 1;
            } else if (k > n / 2) {
                hi = k - 1;
            }
            k = partition(nums, lo, hi);
        }
        return nums[k];
    }

    private static int partition(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return hi;
        }
        int i = lo;
        int j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private static void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


