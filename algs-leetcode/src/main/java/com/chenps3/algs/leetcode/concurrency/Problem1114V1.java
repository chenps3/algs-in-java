package com.chenps3.algs.leetcode.concurrency;


import java.util.concurrent.CountDownLatch;

/**
 * 法1：使用CountDownLatch
 * https://leetcode-cn.com/problems/print-in-order/
 *
 * @Author chenguanhong
 * @Date 2020/3/17
 */
public class Problem1114V1 {

    public static void main(String[] args) {
        Problem1114V1 p = new Problem1114V1();
        Runnable printFirst = () -> System.out.println("first");
        Runnable printSecond = () -> System.out.println("second");
        Runnable printThird = () -> System.out.println("third");
        Thread t1 = new Thread(() ->{
            try {
                p.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() ->{
            try {
                p.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() ->{
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

    public Problem1114V1() {

    }

    private CountDownLatch latch1 = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
