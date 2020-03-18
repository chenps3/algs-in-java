package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/12
 */
public class Offer29 {

    public static void main(String[] args) {
        int[][] m1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] o1 = spiralOrder(m1);
        System.out.println();
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int up = 0;
        int left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        int len = result.length;
        int k = 0;
        while (true) {
            for (int i = left; i <= right; i++) {
                result[k++] = matrix[up][i];
            }
            if (k >= len) {
                break;
            }
            ++up;
            for (int i = up; i <= down; i++) {
                result[k++] = matrix[i][right];
            }
            if (k >= len) {
                break;
            }
            --right;
            for (int i = right; i >= left; i--) {
                result[k++] = matrix[down][i];
            }
            if (k >= len) {
                break;
            }
            --down;
            for (int i = down; i >= up; i--) {
                result[k++] = matrix[i][left];
            }
            if (k >= len) {
                break;
            }
            ++left;
        }
        return result;
    }
}
