package com.chenps3.algs.leetcode.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/4/29
 */
public class Offer45 {

    public static void main(String[] args) {
        int[] a = {3, 30, 34, 5, 9};
        System.out.println(minNumber(a));
    }

    public static String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new CustomComparator());
        StringBuilder sb = new StringBuilder();
        for (String i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }

    //重点是比较器的实现，为什么这样的规则是有效的
    private static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String sum1 = o1 + o2;
            String sum2 = o2 + o1;
            return sum1.compareTo(sum2);        //不需要转化，直接用字符串规则比较
        }
    }
}
