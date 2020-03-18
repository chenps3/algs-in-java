package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 回溯法
 *
 * @Author chenguanhong
 * @Date 2020-03-09
 */
public class Offer13 {

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] visit = new int[m][n];
        check(0, 0, m, n, k, visit);
        int cnt = 0;
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[i].length; j++) {
                if (visit[i][j] == 1) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    private static void check(int x, int y, int m, int n, int k, int[][] visit) {
        if (outOfBound(x, y, m, n)) {
            return;
        }
        if (visit[y][x] > 0) {
            return;
        }
        if (valid(x, y, k, m, n)) {
            visit[y][x] = 1;
            check(x - 1, y, m, n, k, visit);
            check(x + 1, y, m, n, k, visit);
            check(x, y - 1, m, n, k, visit);
            check(x, y + 1, m, n, k, visit);
        } else {
            visit[y][x] = 2;
        }
    }

    private static boolean outOfBound(int x, int y, int m, int n) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    private static boolean valid(int x, int y, int k, int m, int n) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}
