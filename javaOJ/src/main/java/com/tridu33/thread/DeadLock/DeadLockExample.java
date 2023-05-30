package com.tridu33.thread.DeadLock;

public class DeadLockExample {
    /*
    *
互斥条件：指运算单元（进程、线程或协程）对所分配到的资源具有排它性，也就是说在一段时间内某个锁资源只能被一个运算单元所占用。
请求和保持条件：指运算单元已经保持至少一个资源，但又提出了新的资源请求，而该资源已被其它运算单元占有，此时请求运算单元阻塞，但又对自己已获得的其它资源保持不放。
不可剥夺条件：指运算单元已获得的资源，在未使用完之前，不能被剥夺。
环路等待条件：指在发生死锁时，必然存在运算单元和资源的环形链，即运算单元正在等待另一个运算单元占用的资源，而对方又在等待自己占用的资源，从而造成环路等待的情况。
* */
    public static void main(String[] args) {
        Object lockA = new Object(); // 创建锁 A
        Object lockB = new Object(); // 创建锁 B

        // 创建线程 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程 1:获取到锁 A!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程 1:等待获取 B...");
                    synchronized (lockB) {
                        System.out.println("线程 1:获取到锁 B!");
                    }
                }
            }
        });
        t1.start(); // 运行线程

        // 创建线程 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB) {
                    System.out.println("线程 2:获取到锁 B!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程 2:等待获取 A...");
                    synchronized (lockA) {
                        System.out.println("线程 2:获取到锁 A!");
                    }
                }
            }
        });
        t2.start(); // 运行线程
    }
}

class SolveDeadLockExample {
    public static void main(String[] args) {
        Object lockA = new Object(); // 创建锁 A
        Object lockB = new Object(); // 创建锁 B
        // 创建线程 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程 1:获取到锁 A!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程 1:等待获取 B...");
                    synchronized (lockB) {
                        System.out.println("线程 1:获取到锁 B!");
                    }
                }
            }
        });
        t1.start(); // 运行线程
        // 创建线程 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程 2:获取到锁 A!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程 2:等待获取B...");
                    synchronized (lockB) {
                        System.out.println("线程 2:获取到锁 B!");
                    }
                }
            }
        });
        t2.start(); // 运行线程
    }
}