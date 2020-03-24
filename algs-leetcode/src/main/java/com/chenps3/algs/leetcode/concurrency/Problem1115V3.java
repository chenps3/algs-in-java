package com.chenps3.algs.leetcode.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 法3：显式锁
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 * @Author chenguanhong
 * @Date 2020/3/18
 */
public class Problem1115V3 {

    public static void main(String[] args) {
        Problem1115V3 p = new Problem1115V3(5);
        Runnable printFoo = () -> System.out.println("foo");
        Runnable printBar = () -> System.out.println("bar");
        Thread t1 = new Thread(() -> {
            try {
                p.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                p.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.start();
    }


    private int n;

    private Semaphore s1;
    private Semaphore s2;

    public Problem1115V3(int n) {
        this.n = n;
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s1.release();
        }
    }
}
