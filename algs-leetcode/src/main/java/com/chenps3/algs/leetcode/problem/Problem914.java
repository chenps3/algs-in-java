package com.chenps3.algs.leetcode.problem;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 *
 * @Author chenguanhong
 * @Date 2020/3/27
 */
public class Problem914 {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(hasGroupsSizeX(a1));
        int[] a2 = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(hasGroupsSizeX(a2));
        int[] a3 = {1};
        System.out.println(hasGroupsSizeX(a3));
        int[] a4 = {1, 1};
        System.out.println(hasGroupsSizeX(a4));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0) {
            return false;
        }
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            numCount.merge(deck[i], 1, (valOld, valNew) -> valOld + valNew);
        }
        int gcd = 0;
        for (Map.Entry<Integer, Integer> e : numCount.entrySet()) {
            if (gcd == 0) {
                gcd = e.getValue();
                continue;
            }
            gcd = gcd(gcd, e.getValue());
        }
        return gcd >= 2;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
