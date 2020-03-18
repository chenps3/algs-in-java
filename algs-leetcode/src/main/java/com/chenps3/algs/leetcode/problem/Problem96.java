package com.chenps3.algs.leetcode.problem;


/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * <p>
 * 树
 * 动态规划
 *
 * @Author chenguanhong
 * @Date 2020-02-21
 */
public class Problem96 {

    public static void main(String[] args) {
        Problem96 p = new Problem96();
        System.out.println(p.numTrees(3));
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];      //1到n
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp += dp[j] * dp[i - j - 1];
            }
            dp[i] = tmp;
        }
        return dp[n];
    }

}
