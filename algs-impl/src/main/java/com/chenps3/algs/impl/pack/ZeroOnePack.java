package com.chenps3.algs.impl.pack;

/**
 * 01背包问题
 * 有n件物品，c[i]为占用空间，w[i]为价值，背包大小为v
 * 求可以塞入背包的物品的最大价值
 *
 * @Author chenguanhong
 * @Date 2020/4/25
 */
public class ZeroOnePack {

    public static void main(String[] args) {
        int n = 1;
        int[] c = {1, 2, 3};
        int[] w = {1, 2, 3};
        int v = 4;
        System.out.println(zeroOnePack1(n, c, w, v));
        System.out.println(zeroOnePack2(n, c, w, v));
    }

    /**
     * 法1：基于二维数组
     * f[i][j]表示只看前i个物品，总体积是j的情况下，总价值最大是多少
     * result = max(f[n][0~V])
     * 对于f[i][j]:
     * 1. 不选第i个物品 f[i][j] = f[i-1][j]
     * 2. 选第i个物品 f[i][j] = f[i-1][j-c[i]] + w[i]
     * f[i][j] = max(1,2)
     * f[0][0] = 0
     */
    private static int zeroOnePack1(int n, int[] c, int[] w, int v) {
        int[][] f = new int[n + 1][v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= c[i]) {        //体积得足够放下至少一个物品i
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - c[i]] + w[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= v; i++) {
            res = Math.max(res, f[n][i]);
        }
        return res;
    }

    /**
     * 优化1：空间优化用一维数组表示
     * 用f[v]表示第i次循环结束后对应的原f[i][v],因为最终结果要的是f[n][0~v],中间结果不需要保留
     * 根据上面的 f[i][j] = Math.max(f[i][j], f[i - 1][j - c[i]] + w[i])
     * 得 f[j] = Math.max(f[j], f[j - c[i]] + w[i])
     * 左边的f[j]是即第i-1次循环结束后的f[j]，右边是f[j - c[i]]即第i-1次循环结束后的f[j - c[i]]
     * 这就需要保证第i次循环中，计算f[j]时，f[j - c[i]]是第i-1次循环的值，所以对j从大到小迭代
     *
     * 优化2：时间优化
     * f数组初始化状态为没有任何物品可以放入背包的状态，这里把f都初始化成了0
     * f[i]的实际含义是总体积小于等于i的情况下的最大价值
     */
    private static int zeroOnePack2(int n, int[] c, int[] w, int v) {
        int[] f = new int[v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= c[i]; j--) {
                f[j] = Math.max(f[j], f[j - c[i]] + w[i]);
            }
        }
        //不需要遍历f
        return f[v];
    }
}
