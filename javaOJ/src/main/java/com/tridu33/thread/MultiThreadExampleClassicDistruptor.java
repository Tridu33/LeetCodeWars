package com.tridu33.thread;
/**
 * 
 */

import java.lang.*;

/* @Desc:
https://www.zhihu.com/question/316974326/answer/2942835525
 */

public class MultiThreadExampleClassicDistruptor implements Runnable {

    private String threadName;

    public MultiThreadExampleClassicDistruptor(String name) {
        this.threadName = name;
    }

    public void run() {
        System.out.println("Thread " + threadName + " starting.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + threadName + " running. Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public static void main(String[] args) {
        System.out.println("Main thread starting.");
        MultiThreadExampleClassicDistruptor thread1 = new MultiThreadExampleClassicDistruptor("Thread 1");
        MultiThreadExampleClassicDistruptor thread2 = new MultiThreadExampleClassicDistruptor("Thread 2");
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
        System.out.println("Main thread exiting.");
    }
}