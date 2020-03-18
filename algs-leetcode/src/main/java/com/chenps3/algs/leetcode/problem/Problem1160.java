package com.chenps3.algs.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * @Author chenguanhong
 * @Date 2020/3/17
 */
public class Problem1160 {

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters2(words, chars));
    }

    //法2：数组记录，题目限定了是小写字母
    public static int countCharacters2(String[] words, String chars) {
        int[] charsMap = new int[26];
        char[] charsArr = chars.toCharArray();
        for (int i = 0; i < charsArr.length; i++) {
            ++charsMap[charsArr[i] - 'a'];
        }
        int cnt = 0;
        for (String word : words) {
            if (isMaster(word, charsMap)) {
                cnt += word.length();
            }
        }
        return cnt;
    }

    //wordMap统计word字母数，大于charsMap则false，不用修改charsMap
    private static boolean isMaster(String word, int[] charsMap) {
        int[] wordMap = new int[26];
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            ++wordMap[wordArr[i] - 'a'];
        }
        for (int i = 0; i < wordMap.length; i++) {
            if (wordMap[i] > charsMap[i]) {
                return false;
            }
        }
        return true;
    }

    //法1：hashmap
    public static int countCharacters1(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = chars.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            map.merge(charArr[i], 1, (valOld, valNew) -> valOld + valNew);
        }
        int cnt = 0;
        for (String s : words) {
            if (master(s, map)) {
                cnt += s.length();
            }
        }
        return cnt;
    }

    private static boolean master(String word, Map<Character, Integer> map) {
        char[] charArr = word.toCharArray();
        Map<Character, Integer> copy = new HashMap<>(map);
        for (int i = 0; i < charArr.length; i++) {
            Integer cnt = copy.get(charArr[i]);
            if (cnt == null || cnt == 0) {
                return false;
            }
            copy.put(charArr[i], --cnt);
        }
        return true;
    }
}
