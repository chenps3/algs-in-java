package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 * 字符串
 *
 * @Author chenguanhong
 * @Date 2020/3/12
 */
public class Problem1071 {

    public static void main(String[] args) {
//        System.out.println(gcdOfStringsV2("ABCABC", "ABC").equals("ABC"));
//        System.out.println(gcdOfStringsV2("ABABAB", "AB").equals("AB"));
//        System.out.println(gcdOfStringsV2("LEET", "CODE").equals(""));
        System.out.println(gcd(1997, 615));
        System.out.println(gcd(615, 1997));
    }

    //法2
    //结论1：如果存在gcd，必然有str1+str2 = str2+str1
    //结论2：gcd的长度 = gcd(str1.length, str2.length)
    public static String gcdOfStringsV2(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    //辗转相除法:
    //两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数。
    //gcd(a,b) = gcd(b,a mod b) (不妨设a>b 且r=a mod b ,r不为0)
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    //法1：字符串拼接判断
    public static String gcdOfStringsV1(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        if (str1.equals("") || str2.equals("")) {
            return "";
        }
        String gcd = "";
        int maxLen = Math.min(str1.length(), str2.length());
        for (int i = 1; i <= maxLen; i++) {
            if (maxLen % i != 0) {
                continue;
            }
            String tmp = str1.substring(0, i);
            if (tCanDivideS(tmp, str1) && tCanDivideS(tmp, str2)) {
                gcd = tmp;
            }
        }
        return gcd;
    }

    //判断t是否能除尽s
    private static boolean tCanDivideS(String t, String s) {
        if (s.length() % t.length() != 0) {
            return false;
        }
        int times = s.length() / t.length();
        StringBuilder sb = new StringBuilder();
        sb = getStr(t, times, sb);
        return sb.toString().equals(s);
    }

    private static StringBuilder getStr(String t, int times, StringBuilder sb) {
        if (times == 1) {
            return sb.append(t);
        }
        StringBuilder tmp = getStr(t, times / 2, sb);
        if (times % 2 == 0) {
            return tmp.append(tmp.toString());
        } else {
            return tmp.append(tmp.toString()).append(t);
        }
    }
}
