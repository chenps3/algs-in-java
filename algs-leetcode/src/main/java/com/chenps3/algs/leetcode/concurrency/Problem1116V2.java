package com.chenps3.algs.leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 法2 基于Lock+Condition
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * @Author chenguanhong
 * @Date 2020/4/6
 */
public class Problem1116V2 {

    private int n;

    private ReentrantLock lock = new ReentrantLock();

    private Condition zero = lock.newCondition();

    private Condition odd = lock.newCondition();

    private Condition even = lock.newCondition();

    public Problem1116V2(int n) {
        this.n = n;
    }

    private volatile int i;

    private boolean printZero = true;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (!printZero) {
                    zero.await();
                }
                if (i > n) {
                    break;
                }
                printNumber.accept(0);
                if (i % 2 == 0) {
                    even.signal();
                } else {
                    odd.signal();
                }
                printZero = false;
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                even.await();
                if (i > n) {
                    break;
                }
                printNumber.accept(i++);
                printZero = true;
                zero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (i < n) {
            lock.lock();
            try {
                odd.await();
                if (i > n) {
                    break;
                }
                printNumber.accept(i++);
                printZero = true;
                zero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Problem1116V2 p = new Problem1116V2(5);
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
