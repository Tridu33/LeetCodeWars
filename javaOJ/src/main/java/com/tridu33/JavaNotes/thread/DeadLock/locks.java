package com.tridu33.JavaNotes.thread.DeadLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;

public class locks extends Thread {
    private static Integer num = 0;
    private int id;

    public locks() {
    }

    public locks(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (num < 12) {
            num = num + 1;
            System.out.println("Thread" + id + "  结果为  " + num);
        }
    }

    public static void main(String[] args) {
        Thread thread0 = new locks(0);
        Thread thread1 = new locks(1);
        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(thread0);
        exec.submit(thread1);
        exec.shutdown();
    }
}

//如何让两个线程交替输出呢？
//法一：synchronized线程同步
class lock1 extends Thread {
    private static Integer num = 0;
    private int id;

    public lock1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (num < 12) {
            synchronized (lock1.class) {
                num = num + 1;
                System.out.println("thread_" + id + " num:" + num);

                lock1.class.notify();
                try {
                    lock1.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread thread0 = new lock1(0);
        Thread thread1 = new lock1(1);

        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(thread0);
        exec.submit(thread1);
        exec.shutdown();

    }

}
//Lock同步锁

class lock2 extends Thread {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int num = 1;
    private int id;

    public lock2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (num <= 12) {
            lock.lock();

            System.out.println("Thread" + id + " num:" + num);
            num++;

            condition.signal();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread thread0 = new lock2(0);
        Thread thread1 = new lock2(1);

        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(thread0);
        exec.submit(thread1);
        exec.shutdown();

    }

}


//法三：AtomicInteger是线程安全的，自增操作是线程安全的


class lock3 extends Thread {
    private static AtomicInteger atomic = new AtomicInteger(1);
    private int id;

    public lock3(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (atomic.get() <= 12) {
            while (atomic.get() % 3 == id) {
                System.out.println("thread_" + id + " 执行结果:" + atomic.get());
                atomic.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread0 = new lock3(0);
        Thread thread1 = new lock3(1);
        Thread thread2 = new lock3(2);

        ExecutorService exec = Executors.newFixedThreadPool(3);

        exec.submit(thread0);
        exec.submit(thread1);
        exec.submit(thread2);

        exec.shutdown();

    }

}















