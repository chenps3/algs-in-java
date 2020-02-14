package com.chenps3.algs.assignment.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * 无backwash版
 */
public class Percolation {

    private WeightedQuickUnionUF uf;

    private int n;

    private int topIndex;

    private int bottomIndex;

    private boolean[] open;

    private int numberOfOpenSites;

    private int xyTo1D(int row, int col) {
        if (row < 1) {
            return topIndex;
        }
        if (row > n) {
            return bottomIndex;
        }
        return (row - 1) * n + col - 1;
    }

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("");
        }
        uf = new WeightedQuickUnionUF(n * n + 2);
        this.n = n;
        topIndex = n * n;
        bottomIndex = n * n + 1;
        numberOfOpenSites = 0;
        open = new boolean[n * n + 2];
        for (int i = 0; i < open.length; i++) {
            open[i] = false;
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = xyTo1D(row, col);
        if (open[index]) {
            return;
        }
        open[index] = true;
        ++numberOfOpenSites;
        if (isOpen(row - 1, col)) {
            uf.union(index, xyTo1D(row - 1, col));
        }
        if (isOpen(row + 1, col)) {
            uf.union(index, xyTo1D(row + 1, col));
        }
        if (isOpen(row, col - 1)) {
            uf.union(index, xyTo1D(row, col - 1));
        }
        if (isOpen(row, col + 1)) {
            uf.union(index, xyTo1D(row, col + 1));
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (col < 1 || col > n) {
            return false;
        }
        if (row < 1 || row > n) {
            return true;
        }
        int index = xyTo1D(row, col);
        return open[index];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        int index = xyTo1D(row, col);
        return uf.connected(topIndex, index);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(topIndex, bottomIndex);
    }

    private void validateRowCol(int row, int col) {
        if (!(row >= 1 && row <= n && col >= 1 && col <= n)) {
            throw new IndexOutOfBoundsException("");
        }
    }

    // test client (optional)
    public static void main(String[] args) {
        System.out.println("haha");
    }
}
