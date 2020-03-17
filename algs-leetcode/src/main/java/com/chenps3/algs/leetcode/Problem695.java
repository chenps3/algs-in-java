package com.chenps3.algs.leetcode;

/**
 * @Author chenguanhong
 * @Date 2020/3/15
 */
public class Problem695 {

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(a));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int area = dfs(grid, visit, i, j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, boolean[][] visit, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (visit[i][j]) {
            return 0;
        }
        visit[i][j] = true;
        if (grid[i][j] == 0) {
            return 0;
        }
        int area = 1;
        area += dfs(grid, visit, i - 1, j);
        area += dfs(grid, visit, i + 1, j);
        area += dfs(grid, visit, i, j - 1);
        area += dfs(grid, visit, i, j + 1);
        return area;
    }
}
