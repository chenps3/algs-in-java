package com.chenps3.algs.leetcode.problem;

/**
 * 深度优先搜索
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @Author chenguanhong
 * @Date 2020/4/20
 */
public class Problem200 {

    public static void main(String[] args) {
        char[][] a  = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(a));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cnt += dfs(grid, visit, i, j);
            }
        }
        return cnt;
    }

    private static int dfs(char[][] grid, boolean[][] visit, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (visit[i][j]) {
            return 0;
        }
        visit[i][j] = true;
        if (grid[i][j] == '0') {
            return 0;
        }
        dfs(grid, visit, i - 1, j);
        dfs(grid, visit, i + 1, j);
        dfs(grid, visit, i, j - 1);
        dfs(grid, visit, i, j + 1);
        return 1;
    }
}
