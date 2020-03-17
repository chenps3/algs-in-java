package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/compress-string-lcci/
 *
 * @Author chenguanhong
 * @Date 2020/3/16
 */
public class Interview0106 {

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa").equals("a2b1c5a3"));
    }

    public static String compressString(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int cnt = 1;
        char lastChar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == lastChar) {
                ++cnt;
            } else {
                sb.append(lastChar).append(cnt);
                lastChar = arr[i];
                cnt = 1;
            }
        }
        sb.append(lastChar).append(cnt);
        String ss = sb.toString();
        return ss.length() < s.length() ? ss : s;
    }
}
