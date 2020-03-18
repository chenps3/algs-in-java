package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 数组
 * @Author chenguanhong
 * @Date 2020-03-06
 */
public class Offer03 {

    public static void main(String[] args) {
        int[] n = {3, 1, 2, 3};
        int a = findRepeatNumberV2(n);
        System.out.println(a);
    }

    //法1：开个大数组，遍历+记录，空间复杂度O(n)
    public static int findRepeatNumberV1(int[] nums) {
        boolean[] record = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (record[val]) {
                return val;
            } else {
                record[val] = true;
            }
        }
        return 0;
    }

    //法2：在交换的过程中排序，空间复杂度O(1)
    public static int findRepeatNumberV2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int m = nums[i];
            if (m == i) {
                i++;
            } else {
                int n = nums[m];
                if (n == m) {
                    return n;
                } else {
                    swap(nums, i, m);
                }
            }
        }
        return 0;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
