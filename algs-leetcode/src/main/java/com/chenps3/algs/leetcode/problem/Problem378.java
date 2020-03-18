package com.chenps3.algs.leetcode.problem;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * <p>
 * 堆
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-17
 */
public class Problem378 {

    public static void main(String[] args) {
        Problem378 obj = new Problem378();
        int[][] matrix = {
                {2, 6, 6, 7, 10, 14, 18},       //7
                {6, 11, 14, 14, 15, 20, 23},    //7
                {11, 11, 17, 21, 25, 30, 30},   //5
                {11, 12, 20, 25, 25, 35, 37},   //5
                {16, 16, 20, 29, 34, 35, 39},   //3
                {16, 18, 22, 33, 37, 37, 40},   //3
                {17, 23, 26, 36, 38, 41, 42}    //2
        };
        System.out.println(obj.kthSmallest(matrix, 32));
        System.out.println(obj.matrixRank(matrix, 25));
    }

    //法2：二分查找，时间复杂度O(nlogn)
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int midRank = matrixRank(matrix, mid);
            if (midRank < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    //在matrix中，小于等于key的元素数量
    private int matrixRank(int[][] matrix, int key) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            cnt += rowRank(matrix[i], key);
        }
        return cnt;
    }

    //小于等于key的元素数量
    //二分法求右侧边界+1
    private static int rowRank(int[] row, int key) {
        int lo = 0;
        int hi = row.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < row[mid]) {
                hi = mid;
            } else if (key > row[mid]) {
                lo = mid + 1;
            } else if (key == row[mid]) {
                lo = mid + 1;
            }
        }
        return lo;
    }

    //法1：基于最小堆的多路归并
    //没有利用到n*n的特性，以及行有序的特性
    //k<n*n,所以时间复杂度可以是 O(n*n*logn)
    private int solution1(int[][] matrix, int k) {
        if (k <= 0 || matrix.length <= 0 || matrix[0].length <= 0 || k > matrix.length * matrix.length) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Matrix> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.val));
        for (int i = 0; i < k && i < matrix.length; i++) {
            pq.add(new Matrix(matrix[i][0], i, 0));
        }
        Matrix min = null;
        while (k-- > 0 && !pq.isEmpty()) {
            min = pq.poll();
            if (min.col < matrix.length - 1) {
                pq.add(new Matrix(matrix[min.row][min.col + 1], min.row, min.col + 1));
            }
        }
        return min.val;
    }

    private class Matrix {
        private int val;
        private int row;
        private int col;

        public Matrix(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}
