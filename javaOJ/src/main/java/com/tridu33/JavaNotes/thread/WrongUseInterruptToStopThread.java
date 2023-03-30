package com.tridu33.JavaNotes.thread;

public class WrongUseInterruptToStopThread extends Thread {
    private boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        WrongUseInterruptToStopThread t = new WrongUseInterruptToStopThread();
        t.start();
        Thread.sleep(3000);
        t.interrupt();//中断只对阻塞操作生效，这里无法生效，线程没有退出
        Thread.sleep(3000);
        System.out.println("exit");
    }
    @Override
    public void run(){
        while(!stop){
            System.out.println("running");
        };
        System.out.println("stop");
    }
}
