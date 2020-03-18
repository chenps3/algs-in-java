package com.chenps3.algs.leetcode.problem;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 堆
 *
 * @Author chenguanhong
 * @Date 2020-03-05
 */
public class Problem451 {

    public static void main(String[] args) {
        System.out.println(frequencySortV1("tree"));
        System.out.println(frequencySortV1("Aabb"));
    }

    //map+堆排序
    public static String frequencySortV1(String s) {
        Map<Character, CharCount> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            CharCount charCount = map.get(c);
            if (charCount == null) {
                charCount = new CharCount(c, 1);
                map.put(c, charCount);
            } else {
                charCount.cnt++;
            }
        }
        List<CharCount> list = new ArrayList<>(map.values());
        list.sort(new Comparator<CharCount>() {
            @Override
            public int compare(CharCount o1, CharCount o2) {
                return o2.cnt - o1.cnt;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (CharCount cc : list) {
            while (cc.cnt-- > 0) {
                sb.append(cc.c);
            }
        }
        return sb.toString();
    }


    private static class CharCount {
        char c;
        int cnt;

        public CharCount(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}
