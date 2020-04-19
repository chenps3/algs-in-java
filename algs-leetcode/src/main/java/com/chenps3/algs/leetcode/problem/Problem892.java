package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 *
 * @Author chenguanhong
 * @Date 2020/3/25
 */
public class Problem892 {

    public static void main(String[] args) {
        int[][] a1 = {{2}};
        System.out.println(surfaceArea(a1));
        int[][] a2 = {{1, 2}, {3, 4}};
        System.out.println(surfaceArea(a2));
        int[][] a3 = {{1, 0}, {0, 2}};
        System.out.println(surfaceArea(a3));
        int[][] a4 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(surfaceArea(a4));

    }

    //单独计算立方体表面积，减去重叠部分
    public static int surfaceArea(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    int thisArea = 2 * (1 + grid[i][j] + grid[i][j]);
                    area += thisArea;
                    //上
                    if (i - 1 >= 0 && grid[i - 1][j] > 0) {
                        int tmp = Math.min(grid[i][j], grid[i - 1][j]) * 2;
                        area -= tmp;
                    }
                    //左
                    if (j - 1 >= 0 && grid[i][j - 1] > 0) {
                        int tmp = Math.min(grid[i][j], grid[i][j - 1]) * 2;
                        area -= tmp;
                    }

                }
            }
        }
        return area;
    }
}
