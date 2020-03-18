package com.chenps3.algs.leetcode.concurrency;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 法2：使用Semophore
 * https://leetcode-cn.com/problems/print-in-order/
 *
 * @Author chenguanhong
 * @Date 2020/3/17
 */
public class Problem1114V2 {

    public static void main(String[] args) {
        Problem1114V2 p = new Problem1114V2();
        Runnable printFirst = () -> System.out.println("first");
        Runnable printSecond = () -> System.out.println("second");
        Runnable printThird = () -> System.out.println("third");
        Thread t1 = new Thread(() -> {
            try {
                p.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                p.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                p.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }

    public Problem1114V2() {
        s1 = new Semaphore(0);
        s2 = new Semaphore(0);
    }

    private Semaphore s1;
    private Semaphore s2;


    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        s1.acquire();
        printSecond.run();
        s1.release();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        s2.release();
    }
}
