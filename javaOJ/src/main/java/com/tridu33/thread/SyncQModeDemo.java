package com.tridu33.thread;
/**
 * @Date 4/17/2023$.
 */

import java.lang.*;
import java.util.logging.Logger;
/* @Desc:

https://www.cnblogs.com/zfcq/p/15811936.html
 */
public class SyncQModeDemo {
    private static Logger log = Logger.getLogger(SyncQModeDemo.class.toString());
    public static void main(String[] args) throws InterruptedException {

        SyncQModeDemo demo = new SyncQModeDemo();

        demo.startThreadA();
        // 控制线程执行时间
        Thread.sleep(100);
        demo.startThreadB();
        Thread.sleep(100);
        demo.startThreadC();
    }

    final Object lock = new Object();

    public void startThreadA() {
        new Thread(() -> {
            synchronized (lock) {
                log.info("A get lock");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("A release lock");
            }
        }, "thread-A").start();
    }

    public void startThreadB() {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    log.info("B get lock");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("B release lock");
            }
        }, "thread-B").start();
    }

    public void startThreadC() {
        new Thread(() -> {
            synchronized (lock) {

                log.info("C get lock");
            }
        }, "thread-C").start();
    }
}

