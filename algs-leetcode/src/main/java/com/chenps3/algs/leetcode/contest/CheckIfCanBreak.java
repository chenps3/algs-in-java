package com.chenps3.algs.leetcode.contest;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-25/problems/check-if-a-string-can-break-another-string/
 * 双周赛25
 * @Author chenguanhong
 * @Date 2020/5/2
 */
public class CheckIfCanBreak {

    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("leetcodee","interview"));
        System.out.println(checkIfCanBreak("abe","acd"));
        System.out.println(checkIfCanBreak("abc","xya"));

    }

    //s1和s2可以有一个保持不动
    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] charArr1 = s1.toCharArray();
        Arrays.sort(charArr1);
        char[] charArr2 = s2.toCharArray();
        Arrays.sort(charArr2);
        boolean s1BreakS2 = true;
        for (int i = 0; i < charArr1.length; i++) {
            if (charArr1[i] < charArr2[i]) {
                s1BreakS2 = false;
                break;
            }
        }
        if (s1BreakS2) {
            return true;
        }
        boolean s2BreakS1 = true;
        for (int i = 0; i < charArr1.length; i++) {
            if (charArr1[i] > charArr2[i]) {
                s2BreakS1 = false;
                break;
            }
        }
        return s2BreakS1;
    }


    private static boolean xBreakY(char[] x, char[] y) {
        if (x.length != y.length) {
            return false;
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i] < y[i]) {
                return false;
            }
        }
        return true;
    }
}
