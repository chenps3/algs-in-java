package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-25
 */
public class Problem74 {

    public static void main(String[] args) {
        int[][] m1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {20, 30, 34, 50}
        };
        int[][] m2 = {{1, 1}};
        System.out.println(searchMatrix(m1, 3));
        System.out.println(searchMatrix(m1, 13));
        System.out.println(searchMatrix(m2, 2));

    }

    //解法1，从矩阵左下角或右上角开始搜索
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = row - 1;
        while (x <= col - 1 && y >= 0) {
            if (target == matrix[y][x]) {
                return true;
            } else if (target > matrix[y][x]) {
                x++;
            } else if (target < matrix[y][x]) {
                y--;
            }
        }
        return false;
    }

    //解法2 二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = 0;
        int hi = row * col - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int x = mid % col;
            int y = mid / col;
            if (target == matrix[y][x]) {
                return true;
            } else if (target > matrix[y][x]) {
                lo = mid + 1;
            } else if (target < matrix[y][x]) {
                hi = mid - 1;
            }
        }
        return false;
    }
}
