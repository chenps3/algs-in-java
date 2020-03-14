package com.chenps3.algs.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @Author chenguanhong
 * @Date 2020/3/13
 */
public class Problem169 {

    public static void main(String[] args) {
        int[] a = {3, 2, 3};
        System.out.println(majorityElementV1(a));
    }

    //hashmap
    public static int majorityElementV1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int maxValue = Integer.MIN_VALUE;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > maxValue) {
                maxValue = e.getValue();
                maxKey = e.getKey();
            }
        }
        return maxKey;
    }
}
