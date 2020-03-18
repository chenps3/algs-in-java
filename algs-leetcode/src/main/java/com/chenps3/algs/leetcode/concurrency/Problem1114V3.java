package com.chenps3.algs.leetcode.concurrency;

/**
 * 法3：使用volatile变量 or 原子变量
 * https://leetcode-cn.com/problems/print-in-order/
 *
 * @Author chenguanhong
 * @Date 2020/3/17
 */
public class Problem1114V3 {

    public static void main(String[] args) {
        Problem1114V3 p = new Problem1114V3();
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

    public Problem1114V3() {
        stage = 1;
    }

    private volatile int stage;


    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        stage = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (stage!=2){
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        stage = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (stage!=3){
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
