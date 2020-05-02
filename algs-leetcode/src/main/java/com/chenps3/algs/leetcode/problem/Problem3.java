package com.chenps3.algs.leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author chenguanhong
 * @Date 2020/5/2
 */
public class Problem3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int lo = 0;
        int hi = 1;
        set.add(chars[0]);
        int max = 1;
        while (hi < chars.length) {
            if (!set.contains(chars[hi])) {
                set.add(chars[hi]);
                if (set.size() > max) {
                    max = set.size();
                }
            } else {
                while (chars[lo] != chars[hi]) {
                    set.remove(chars[lo++]);
                }
                lo++;
            }
            hi++;
        }
        return max;
    }
}
