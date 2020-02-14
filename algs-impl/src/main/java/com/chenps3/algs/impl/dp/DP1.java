package com.chenps3.algs.impl.dp;

/**
 * 问题：有1元 5元 11元面值的钞票，给定输入n，求凑出n元所需的最少钞票数
 * 思路：f(n)为
 * f(n-1) + 1
 * f(n-5) + 1
 * f(n-11) + 1
 * 的最小值,只需要从小到大一次求出所有的f(i)即可，时间复杂度O(n)
 */
public class DP1 {

    public static void main(String[] args) {
        System.out.println("solution is " + solution(15));
    }

    static String solution(int n) {
        int[] f = new int[105];
        int[] opt = new int[105];       //opt[x]表示凑出x所需的最后一张钞票面值
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            int cost = Integer.MAX_VALUE;
            int money = 1;
            if (i >= 1) {
                int tmp = min(cost, f[i - 1] + 1);
                if (cost != tmp) {
                    cost = tmp;
                    money = 1;
                }
            }
            if (i >= 5) {
                int tmp = min(cost, f[i - 5] + 1);
                if (cost != tmp) {
                    cost = tmp;
                    money = 5;
                }
            }
            if (i >= 11) {
                int tmp = min(cost, f[i - 11] + 1);
                if (cost != tmp) {
                    cost = tmp;
                    money = 11;
                }
            }
            f[i] = cost;
            opt[i] = money;
            System.out.println("f(" + i + ")=" + cost);
        }
        int m = n;
        String detail = String.valueOf(f[n]) + "\n";
        while (m > 0) {
            detail += String.valueOf(opt[m]) + " ";
            m -= opt[m];
        }
        return detail;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }
}
