package com.chenps3.algs.impl.pack;

/**
 * 完全背包问题
 * 有n件物品，c[i]为物品i占用空间，w[i]为物品i的价值，每件物品可以放多个，背包大小为v
 * 求可以塞入背包的物品的最大价值
 * @Author chenguanhong
 * @Date 2020/4/28
 */
public class CompletePack {

    public static void main(String[] args) {

    }

    /**
     * f(i,v) = max{f(i-1,v-kc[i]) + kw[i], 0<=kc[i]<=v}
     * f(i,v-c[i]) = max{f(i-1,v-c[i]-kc[i]) + kw[i], 0<=kc[i]<=v-c[i]}
     *             = max{f(i-1,v-c[i]-kc[i]) + kw[i], 0<=kc[i]<=v-c[i]}
     */
    private static int completePack(int n, int[] c, int[] w, int v){
        return 0;
    }
}
