package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 *
 * @Author chenguanhong
 * @Date 2020/3/11
 */
public class Problem1013 {

    public static void main(String[] args) {
//        int[] a1 = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
//        System.out.println(canThreePartsEqualSum(a1));
//        int[] a2 = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
//        System.out.println(canThreePartsEqualSum(a2));

        int[] a3 = {1, -1, 1, -1};  //
        System.out.println(canThreePartsEqualSum(a3));
    }

    //每个部分的和一定是总的sum/3
    public static boolean canThreePartsEqualSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        //两边同时遍历
        int lo = 0;
        int hi = a.length - 1;
        int loSum = a[lo];
        int hiSum = a[hi];
        while (hi - lo > 1) {
            if (loSum == sum / 3 && hiSum == sum / 3) {
                return true;
            }
            if (loSum != sum / 3) {
                ++lo;
                loSum += a[lo];
            }
            if (hiSum != sum / 3) {
                --hi;
                hiSum += a[hi];
            }
        }
        return false;
    }
}
