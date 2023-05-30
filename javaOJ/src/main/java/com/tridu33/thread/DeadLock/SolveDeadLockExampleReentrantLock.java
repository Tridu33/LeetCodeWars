package com.tridu33.thread.DeadLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 轮询锁解决死锁问题
//https://zhuanlan.zhihu.com/p/404411203

class SolveDeadLockExampleReentrantLock {

    public static void main(String[] args) {
        Lock lockA = new ReentrantLock(); // 创建锁 A
        Lock lockB = new ReentrantLock(); // 创建锁 B

        // 创建线程 1(使用轮询锁)
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用轮询锁
                pollingLock(lockA, lockB);
            }
        });
        t1.start(); // 运行线程

        // 创建线程 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockB.lock(); // 加锁
                System.out.println("线程 2:获取到锁 B!");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程 2:等待获取 A...");
                    lockA.lock(); // 加锁
                    try {
                        System.out.println("线程 2:获取到锁 A!");
                    } finally {
                        lockA.unlock(); // 释放锁
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockB.unlock(); // 释放锁
                }
            }
        });
        t2.start(); // 运行线程
    }

    /**
     * 轮询锁
     */
    public static void pollingLock(Lock lockA, Lock lockB) {
        while (true) {
            if (lockA.tryLock()) { // 尝试获取锁
                System.out.println("线程 1:获取到锁 A!");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程 1:等待获取 B...");
                    if (lockB.tryLock()) { // 尝试获取锁
                        try {
                            System.out.println("线程 1:获取到锁 B!");
                        } finally {
                            lockB.unlock(); // 释放锁
                            System.out.println("线程 1:释放锁 B.");
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockA.unlock(); // 释放锁
                    System.out.println("线程 1:释放锁 A.");
                }
            }
            // 等待一秒再继续执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

