package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 字符串
 * @Author chenguanhong
 * @Date 2020-03-06
 */
public class Offer05 {

    public static void main(String[] args) {
        String s1 = "We are happy.";
        String a1 = replaceSpace2(s1);
        System.out.println(a1);
    }

    //法1：利用StringBuilder
    public static String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //法2：char数组
    public static String replaceSpace2(String s) {
        char[] arr1 = s.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == ' ') {
                spaceCount++;
            }
        }
        char[] arr2 = new char[arr1.length + 2 * spaceCount];   //' '替换为'%''2''0'
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (arr1[i1] == ' ') {
                arr2[i2--] = '0';
                arr2[i2--] = '2';
                arr2[i2--] = '%';
            } else {
                arr2[i2--] = arr1[i1];
            }
            --i1;
        }
        return new String(arr2);
    }
}
