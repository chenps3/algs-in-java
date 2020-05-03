package com.chenps3.algs.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * 双周赛25
 * https://leetcode-cn.com/contest/biweekly-contest-25/problems/kids-with-the-greatest-number-of-candies/
 *
 * @Author chenguanhong
 * @Date 2020/5/2
 */
public class KidsWithCandies {

    public static void main(String[] args) {
        int[] c1 = {12, 1, 12};
        List<Boolean> list = kidsWithCandies(c1, 10);
        for (Boolean b : list) {
            System.out.println(b);
        }
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies) {
            if (i > max) {
                max = i;
            }
        }
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            int tmp = candies[i] + extraCandies;
            if (tmp >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }


}
