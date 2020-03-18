package com.chenps3.algs.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * 最优解：使用hash表存储，一次遍历
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] x = solution3(nums, target);
        for (int i : x) {
            System.out.println(i);
        }
    }

    //暴力搜索 O(n2)
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    //hashmap两次遍历 O(n)
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //保存数字的下标
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            Integer j = map.get(another);
            if (j != null && j != i) {
                return new int[]{i, map.get(another)};
            }
        }
        return new int[]{0, 0};
    }

    //hashmap一次遍历 O(n)
    public static int[] solution3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>(); //保存数字的下标
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            Integer j = map.get(another);
            if (j != null && j != i) {
                return new int[]{i, j};
            }
            else{
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
