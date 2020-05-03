package com.chenps3.algs.leetcode.contest;

/**
 * 双周赛25
 * https://leetcode-cn.com/contest/biweekly-contest-25/problems/max-difference-you-can-get-from-changing-an-integer/
 *
 * @Author chenguanhong
 * @Date 2020/5/2
 */
public class MaxDiff {

    public static void main(String[] args) {
        System.out.println(maxDiff(555));
        System.out.println(maxDiff(9));
        System.out.println(maxDiff(123456));
        System.out.println(maxDiff(10000));
        System.out.println(maxDiff(9288));
        System.out.println(maxDiff(1101057));
    }

    public static int maxDiff(int num) {
        String str = String.valueOf(num);
        char[] charArr = str.toCharArray();

        int k = -1;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != '9') {
                k = i;
                break;
            }
        }
        Integer a = num;
        if (k != -1) {
            StringBuilder sb1 = new StringBuilder();
            for (char c : charArr) {
                if (c == charArr[k]) {
                    sb1.append('9');
                } else {
                    sb1.append(c);
                }
            }
            a = Integer.valueOf(sb1.toString());
        }

        //第1位不是'1'，把第1位和其他位替换成'1'
        //第1位是'1'，其他非0位可以替换成'0'
        k = -1;
        char minReplace = '1';
        if (charArr[0] == '1') {
            minReplace = '0';
        }
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != '1' && charArr[i] != '0') {
                k = i;
                break;
            }
        }
        Integer b = num;
        if (k != -1) {
            StringBuilder sb2 = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (c == charArr[k]) {
                    sb2.append(minReplace);
                } else {
                    sb2.append(c);
                }
            }
            b = Integer.valueOf(sb2.toString());
        }
        return a - b;
    }


}
