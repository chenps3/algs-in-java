package com.chenps3.algs.leetcode.concurrency;

/**
 * 法1：无锁方案
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 * @Author chenguanhong
 * @Date 2020/3/18
 */
public class Problem1115V1 {

    public static void main(String[] args) {
        Problem1115V1 p = new Problem1115V1(5);
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

    private volatile boolean state;

    private int n;

    public Problem1115V1(int n) {
        this.n = n;
        state = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if (state) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                i++;
                state = false;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if(!state){
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                i++;
                state = true;
            }
        }
    }
}
