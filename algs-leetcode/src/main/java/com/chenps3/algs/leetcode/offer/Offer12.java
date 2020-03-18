package com.chenps3.algs.leetcode.offer;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 回溯
 *
 * @Author chenguanhong
 * @Date 2020-03-09
 */
public class Offer12 {

    public static void main(String[] args) {

    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        int k = 0;
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (check(j, i, board, words, k, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(int x, int y, char[][] board, char[] words, int k, boolean[][] visit) {
        if (k == words.length) {
            return true;
        }
        boolean hasPath = false;
        if (x >= 0 && x < board[0].length && y >= 0 && y < board.length && board[y][x] == words[k] && !visit[y][x]) {
            ++k;
            visit[y][x] = true;
            //检查左右上下
            hasPath = check(x - 1, y, board, words, k, visit) || check(x + 1, y, board, words, k, visit)
                    || check(x, y - 1, board, words, k, visit) || check(x, y + 1, board, words, k, visit);
            if (!hasPath) {
                --k;
                visit[y][x] = false;
            }
        }
        return hasPath;
    }
}
