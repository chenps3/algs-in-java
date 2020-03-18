package com.chenps3.algs.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 剑指offer
 *
 * @Author chenguanhong
 * @Date 2020-03-06
 */
public class Offer57I {

    public static void main(String[] args) {
        int[][] a1 = findContinuousSequence(15);
        System.out.println();
    }

    public static int[][] findContinuousSequence(int target) {
        int hi = target % 2 == 0 ? target / 2 : target / 2 + 1; //最大值在一半左右
        int left = 1;
        int right = 2;
        List<int[]> list = new ArrayList<>();
        while (left < right && right <= hi) {
            int sum = sum(left, right);       //等差数列求和
            if (sum < target) {
                right++;
            } else if (sum > target) {
                left++;
            } else if (sum == target) {
                list.add(generateArr(left, right));
                left++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static int sum(int lo, int hi) {
        return (lo + hi) * (hi - lo + 1) / 2;
    }

    private static int[] generateArr(int lo, int hi) {
        int[] arr = new int[hi - lo + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lo++;
        }
        return arr;
    }


}
