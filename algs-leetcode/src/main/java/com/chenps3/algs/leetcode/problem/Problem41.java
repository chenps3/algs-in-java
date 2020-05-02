package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 * 数组
 * @Author chenguanhong
 * @Date 2020/4/30
 */
public class Problem41 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 0};
//        int[] nums = {3, 4, -1, 1};
//        int[] nums = {7, 8, 9, 11, 12};
        int[] nums = {1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    //性质：首个缺失的正数k,一定满足 k <= n+1
    public static int firstMissingPositive(int[] nums) {
        //第一次遍历，把小于0的数替换为0，大于n的数替换为0,确保第二次遍历不会越界
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length || nums[i] < 0) {
                nums[i] = 0;
            }
        }
        //第二次遍历，如果存在数值x>0，下标x-1的位置设置为x
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            while (x > 0 && nums[x - 1] != x) {
                int tmp = nums[x - 1];
                nums[x - 1] = x;
                x = tmp;
            }
        }
        //第三次遍历，找出正数k
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //可能k正好是n+1;
        return nums.length + 1;
    }

    private static void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
