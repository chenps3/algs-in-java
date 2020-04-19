package com.chenps3.algs.leetcode.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * https://leetcode-cn.com/problems/building-h2o/
 *
 * @Author chenguanhong
 * @Date 2020/4/6
 */
public class Problem1117V1 {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

    public Problem1117V1() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }
}
