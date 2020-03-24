package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 *
 * @Author chenguanhong
 * @Date 2020/3/23
 */
public class Problem945 {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(a));
    }

    public static int minIncrementForUnique(int[] A) {
        int[] aux = new int[80000];         //A最多40000个元素，最大值40000，最坏情况下是40000个40000，开80000的数组统计足矣
        for (int i = 0; i < A.length; i++) {
            ++aux[A[i]];
        }
        int cnt = 0;
        for (int i = 0; i < aux.length - 1; i++) {
            if (aux[i] > 1) {
                aux[i + 1] += aux[i] - 1;
                cnt += aux[i] - 1;
            }
        }
        return cnt;
    }
}
