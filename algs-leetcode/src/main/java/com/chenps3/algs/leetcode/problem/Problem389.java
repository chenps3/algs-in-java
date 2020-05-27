package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/find-the-difference/
 * @Author chenguanhong
 * @Date 2020/5/14
 */
public class Problem389 {

    public char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        if(ss.length == 0){
            return tt[0];
        }
        char x = ss[0];
        for(int i = 1;i < ss.length;i++){
            x^=ss[i];
        }
        for(int i = 0;i < tt.length;i++){
            x^=tt[i];
        }
        return x;
    }
}
