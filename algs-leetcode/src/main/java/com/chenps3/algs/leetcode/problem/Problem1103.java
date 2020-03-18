package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 * <p>
 * 数学
 *
 * @Author chenguanhong
 * @Date 2020-03-05
 */
public class Problem1103 {

    public static void main(String[] args) {
        int[] a = distributeCandies(7, 4);
        print(a);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int k = 1;
        while (candies > 0) {
            for (int i = 0; i < res.length; i++) {
                if (candies <= 0) {
                    break;
                }
                if (candies >= k) {
                    res[i] += k;
                    candies -= k;
                    k++;
                } else {
                    res[i] += candies;
                    candies = 0;
                }
            }
        }
        return res;
    }
}
