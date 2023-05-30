package com.tridu33.thread.ThreadPool;
/**
 * @Date 5/2/2023$.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;
/** @Desc:
 10分钟带你徒手做个Java线程池 - 华为云开发者联盟的文章 - 知乎
 https://zhuanlan.zhihu.com/p/623169452
 * @description 自定义线程池
 */
public class MyThreadPool {
    //默认阻塞队列大小
    private static final int DEFAULT_WORKQUEUE_SIZE = 5;
    //模拟实际的线程池使用阻塞队列来实现生产者-消费者模式
    private BlockingQueue<Runnable> workQueue;
    //模拟实际的线程池使用List集合保存线程池内部的工作线程
    private List<WorkThread> workThreads = new ArrayList<WorkThread>();
    //在ThreadPool的构造方法中传入线程池的大小和阻塞队列
    public MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue){
        this.workQueue = workQueue;
        //创建poolSize个工作线程并将其加入到workThreads集合中
        IntStream.range(0, poolSize).forEach((i) -> {
            WorkThread workThread = new WorkThread();
            workThread.start();
            workThreads.add(workThread);
        });
    }
    //在ThreadPool的构造方法中传入线程池的大小
    public MyThreadPool(int poolSize){
        this(poolSize, new LinkedBlockingQueue<>(DEFAULT_WORKQUEUE_SIZE));
    }
    //通过线程池执行任务
    public void execute(Runnable task){
        try {
            workQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //内部类WorkThread，模拟线程池中的工作线程
    //主要的作用就是消费workQueue中的任务，并执行
    //由于工作线程需要不断从workQueue中获取任务，使用了while(true)循环不断尝试消费队列中的任务
    class WorkThread extends Thread{
        @Override
        public void run() {
            //不断循环获取队列中的任务
            while (true){
                //当没有任务时，会阻塞
                try {
                    Runnable workTask = workQueue.take();
                    workTask.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        MyThreadPool threadPool1 = new MyThreadPool(10);
        IntStream.range(0, 10).forEach((i) -> {
            threadPool1.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "--->> Hello ThreadPool");
            });
        });
    }
}


