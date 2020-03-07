package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 数组
 * @Author chenguanhong
 * @Date 2020-03-06
 */
public class Offer04 {

    public static void main(String[] args) {

    }

    //法1：从左下或右上找
    public static boolean findNumberIn2DArrayV1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val > target) {
                row--;
            } else if (val < target) {
                col++;
            }
        }
        return false;
    }

    //法2，逐行二分
}
