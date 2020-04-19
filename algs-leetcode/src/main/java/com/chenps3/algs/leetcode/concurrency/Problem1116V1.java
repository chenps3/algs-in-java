package com.chenps3.algs.leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 法1 基于信号量
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * @Author chenguanhong
 * @Date 2020/4/6
 */
public class Problem1116V1 {

    private int n;

    private Semaphore odd = new Semaphore(0);

    private Semaphore even = new Semaphore(0);

    private Semaphore zero = new Semaphore(1);

    public Problem1116V1(int n) {
        this.n = n;
    }


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                even.release();
            } else {
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public static void main(String[] args) {
        Problem1116V1 p = new Problem1116V1(5);
        Thread t1 = new Thread(() -> {
            try {
                p.zero(i -> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                p.odd(i -> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                p.even(i -> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
