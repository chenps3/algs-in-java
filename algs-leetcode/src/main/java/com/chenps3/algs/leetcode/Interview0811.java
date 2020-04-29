package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/coin-lcci/
 * 动态规划
 *
 * @Author chenguanhong
 * @Date 2020/4/23
 */
public class Interview0811 {

    public static void main(String[] args) {
        System.out.println(waysToChange2(5));
        System.out.println(waysToChange2(10));
        System.out.println(waysToChange2(25));
    }

    /**
     * 优化时间复杂度，因为f[i][j] = sum{f[i-1][j-kc[i]], 0<=kc[i]<=j}
     * 即f[i][j] = f[i-1][j] + f[i-1][j-c[i]] + f[i-1][j-2c[i]] + ... + f[i-1][j-kc[i]]      (1)
     * f[i][j-c[i]] = f[i-1][j-c[i]] + f[i-1][j-2c[i]] + ... + f[i-1][j-kc[i]]               (2)
     * (1)-(2)得
     * f[i][j]  = f[i-1][j] + f[i][j-c[i]]   (3)
     */
    public static int waysToChange2(int n) {
        int mod = 1000000007;
        int[] coins = {0, 1, 5, 10, 25};
        int[][] f = new int[5][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - coins[i] >= 0) {
                    f[i][j] = (f[i - 1][j] + f[i][j - coins[i]]) % mod;
                }else{
                    f[i][j] = f[i - 1][j] % mod;
                }
            }
        }
        return f[4][n];
    }

    /**
     * 基本思路-超时
     * f[i][j]:只选前i种硬币，总价值为j，一共多少中方案
     * result = f[4][n]
     * f[i][j] = sum{f[i-1][j-kc[i]], 0<=kc[i]<=j}
     */
    public static int waysToChange1(int n) {
        int[] coins = {0, 1, 5, 10, 25};
        int[][] f = new int[5][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k * coins[i] <= j; k++) {
                    f[i][j] += f[i - 1][j - k * coins[i]];
                }
            }
        }
        return f[4][n];
    }
}
