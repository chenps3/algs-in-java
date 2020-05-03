package com.chenps3.algs.leetcode.contest;

import java.util.Arrays;
import java.util.List;

/**
 * 双周赛25
 * https://leetcode-cn.com/contest/biweekly-contest-25/problems/number-of-ways-to-wear-different-hats-to-each-other/
 *
 * @Author chenguanhong
 * @Date 2020/5/2
 */
public class NumberWays {

    public static void main(String[] args) {
        List<Integer> a1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> a2 = Arrays.asList(1, 2, 3, 4);
        List<Integer> a3 = Arrays.asList(1, 2, 3, 4);
        List<Integer> a4 = Arrays.asList(1, 2, 3, 4);

        List<List<Integer>> hats = Arrays.asList(a1, a2, a3, a4);
        System.out.println(numberWays(hats));
    }

    //dp[i][j]表示如果前i人选了前j个帽子，有多少种方案
    public static int numberWays(List<List<Integer>> hats) {
        int[][] dp = new int[hats.size()][41];
        for (Integer i : hats.get(0)) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < hats.size(); i++) {
            List<Integer> likes = hats.get(i);
            for (int j = 0; j < likes.size(); j++) {
                int hatNum = likes.get(i);
                for (int k = 0; k < 41; k++) {
                    if (k != hatNum) {
                        dp[i][hatNum] += dp[i - 1][k];
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 41; i++) {
            res += dp[hats.size() - 1][i];
        }
        return res;
    }
}
