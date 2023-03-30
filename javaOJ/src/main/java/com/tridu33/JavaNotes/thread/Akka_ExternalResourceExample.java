package com.tridu33.JavaNotes.thread;
import akka.actor.*;
/*
* 在这个例子中，我们定义了两个Actor，一个Requester和一个Worker。
* Requester会向两个Worker发送消息，请求它们模拟请求外部资源的操作。
* 每个Worker会随机休眠一段时间（模拟请求耗时），
* 然后向Requester发送响应消息。
* Requester在收到两个Worker的响应后退出。
链接：https://www.zhihu.com/question/316974326/answer/2942835525

* */
import java.util.Random;
import java.util.concurrent.*;

public class Akka_ExternalResourceExample {

    public static void main(String[] args) throws Exception {
        System.out.println("Main thread starting.");
        ActorSystem system = ActorSystem.create("mySystem");
        ActorRef requester = system.actorOf(Props.create(Requester.class));
        requester.tell("start", null);
        system.shutdown();
        System.out.println("Main thread exiting.");
    }

    public static class Requester extends UntypedActor {

        private final ActorRef worker1;
        private final ActorRef worker2;
        private final CountDownLatch latch;
        private long startTime;

        public Requester() {
            this.worker1 = getContext().actorOf(Props.create(Worker.class));
            this.worker2 = getContext().actorOf(Props.create(Worker.class));
            this.latch = new CountDownLatch(2);
            this.startTime = 0;
        }

        @Override
        public void onReceive(Object message) {
            if (message instanceof String) {
                String msg = (String) message;
                if (msg.equals("start")) {
                    startTime = System.currentTimeMillis();
                    System.out.println("Requester starting.");
                    worker1.tell("request", getSelf());
                    worker2.tell("request", getSelf());
                } else if (msg.equals("response")) {
                    latch.countDown();
                    if (latch.getCount() == 0) {
                        long endTime = System.currentTimeMillis();
                        System.out.println("Requester exiting. Total time: " + (endTime - startTime) + "ms");
                        getContext().system().shutdown();
                    }
                }
            } else {
                unhandled(message);
            }
        }
    }

    public static class Worker extends UntypedActor {

        private final Random random;

        public Worker() {
            this.random = new Random();
        }

        @Override
        public void onReceive(Object message) {
            if (message instanceof String) {
                String msg = (String) message;
                if (msg.equals("request")) {
                    System.out.println("Worker " + getSelf().path().name() + " starting.");
                    long sleepTime = random.nextInt(5000);
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        System.out.println("Worker " + getSelf().path().name() + " interrupted.");
                    }
                    System.out.println("Worker " + getSelf().path().name() + " done. Time: " + sleepTime + "ms");
                    getSender().tell("response", getSelf());
                }
            } else {
                unhandled(message);
            }
        }
    }
}