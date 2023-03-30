package com.tridu33.JavaNotes.thread;
/* (1) Thread.stop(), Thread.suspend(), Thread.resume() 和Runtime.runFinalizersOnExit() 这些终止线程运行的方法 。这些方法已经被废弃，使用它们是极端不安全的。
 (2) Thread.interrupt() 方法是很好的选择。
无法中断正在运行的线程代码. sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。
 当th1被阻塞的时候，比如被Object.wait, Thread.join和Thread.sleep三种方法之一阻塞时。调用它的interrput()方法。


一个线程对象调用了sleep方法之后，并不会释放他所持有的所有对象锁，所以也就不会影响其他进程对象的运行。
但在 sleep的过程中过程中有可能被其他对象调用它的interrupt()，产生InterruptedException异常，
如果你的程序不捕获这个异常，线程就会异常终止，进入TERMINATED状态，
如果你的程序捕获了这个异常，那么程序就会继续执行catch语句块（可能还有finally语句块）以及以后的代码。

一个对象调用了wait方法，必须要采用notify()和notifyAll()方法唤醒该进程。
如果线程拥有某个或某些对象的同步锁，那么在调用了wait()后，这个线程就会释放它持有的所有同步资源，
而不限于这个被调用了wait()方法的对象。从而使线程所在对象中的其它synchronized数据可被别的线程使用。
wait()方法也同样会在wait的过程中有可能被其他对象调用interrupt()方法而产生InterruptedException，
效果以及处理方式同sleep()方法。
 */
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try{
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        }catch (InterruptedException e){
            System.out.println("在沉睡中被停止！进入catch！"+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
class SleepInterrupt200 {
    public static void main(String[] args){
        try{
            MyThread thread=new MyThread();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
    /*    run begin
end!
在沉睡中被停止！进入catch！false
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep0(Native Method)
	at java.base/java.lang.Thread.sleep(Thread.java:465)
	at com.tridu33.JavaNotes.thread.MyThread.run(SleepInterrupt.java:9)
    * */
}
class SleepInterrupt {
    public static void main(String[] args){
        try{
            MyThread thread=new MyThread();
            thread.start();
            Thread.sleep(1);
            thread.interrupt();
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
    /*  run begin
end!
在沉睡中被停止！进入catch！false
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep0(Native Method)
	at java.base/java.lang.Thread.sleep(Thread.java:465)
	at com.tridu33.JavaNotes.thread.MyThread.run(SleepInterrupt.java:9)

    * */
}

class InterruptThenSleep200 {
    public static void main(String[] args){
        try{
            MyThread thread=new MyThread();
            thread.start();
            thread.interrupt();
            Thread.sleep(200);
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
    /*    run begin
在沉睡中被停止！进入catch！false
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep0(Native Method)
	at java.base/java.lang.Thread.sleep(Thread.java:465)
	at com.tridu33.JavaNotes.thread.MyThread.run(SleepInterrupt.java:9)
end!

    * */
}