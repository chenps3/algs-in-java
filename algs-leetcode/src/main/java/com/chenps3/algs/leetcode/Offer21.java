package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer21 {

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = exchange(a);
        System.out.println();
    }

    public static int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            if (nums[lo] % 2 != 0) {
                ++lo;
                continue;
            }
            if (nums[hi] % 2 == 0) {
                --hi;
                continue;
            }
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
        }
        return nums;
    }
}
