package com.chenps3.algs.unionfind;

public class LeetCode130 {

    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        int ysize = board.length;
        int xsize = board[0].length;
        int virtualTopIndex = ysize * xsize;
        int virtualBottomIndex = ysize * xsize + 1;
        int virtualLeftIndex = ysize * xsize + 2;
        int virtualRightIndex = ysize * xsize + 3;
        UnionFind uf = new UnionFind(ysize * xsize + 4);
        for (int i = 0; i < ysize; i++) {
            for (int j = 0; j < xsize; j++) {
                int ufIndex = getIndex(i, j, xsize);
                if (board[i][j] == 'O') {
                    if (i == 0) {
                        uf.union(ufIndex, virtualTopIndex);
                    }
                    if (i == ysize - 1) {
                        uf.union(ufIndex, virtualBottomIndex);
                    }
                    if (j == 0) {
                        uf.union(ufIndex, virtualLeftIndex);
                    }
                    if (j == xsize - 1) {
                        uf.union(ufIndex, virtualRightIndex);
                    }
                }
            }
        }
    }

    //二维坐标对应的一维坐标
    private int getIndex(int i, int j, int xsize) {
        return i + j * xsize;
    }

    private class UnionFind {

        int[] arr;

        private UnionFind(int size) {
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }
        }

        private void union(int p, int q) {

        }

        private boolean connected(int p, int q) {
            return false;
        }
    }
}
