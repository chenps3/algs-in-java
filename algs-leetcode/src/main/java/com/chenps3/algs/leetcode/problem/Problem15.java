package com.chenps3.algs.leetcode.problem;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 排序+双指针
 * 数组
 * @Author chenguanhong
 * @Date 2020/4/30
 */
public class Problem15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = threeSum(nums);
        for (List<Integer> list : threeSum) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {          //三数之和必然无法等于 0，结束循环
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  //该数字重复，会导致结果重复，所以应该跳过
                continue;
            }
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) {     //nums[lo] == nums[lo+1] 会导致结果重复，应该跳过
                        ++lo;
                    }
                    while (lo < hi && nums[hi] == nums[hi - 1]) {     //nums[hi] == nums[hi-1] 会导致结果重复，应该跳过
                        --hi;
                    }
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    ++lo;
                } else if (sum > 0) {
                    --hi;
                }
            }
        }
        return res;
    }
}
