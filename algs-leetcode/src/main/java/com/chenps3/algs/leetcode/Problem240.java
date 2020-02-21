package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * <p>
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-18
 */
public class Problem240 {

    public static void main(String[] args) {
        Problem240 p = new Problem240();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 20;
        System.out.println(p.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return solition1(matrix, target);
    }

    //法1，逐行二分查找
    private boolean solition1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            boolean found = rowBinarySearch(matrix[i], target);
            if (found) {
                return true;
            }
        }
        return false;
    }

    private boolean rowBinarySearch(int[] row, int target) {
        int lo = 0;
        int hi = row.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target > row[mid]) {
                lo = mid + 1;
            } else if (target < row[mid]) {
                hi = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
