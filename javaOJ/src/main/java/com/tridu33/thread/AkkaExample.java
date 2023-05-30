package com.tridu33.thread;
/**
 * @Date 3/20/2023$.
 */

import java.lang.*;

/* @Desc:

https://www.zhihu.com/question/316974326/answer/2942835525

 */

import akka.actor.*;

public class AkkaExample extends UntypedActor {

    private String threadName;

    public AkkaExample(String name) {
        this.threadName = name;
    }

    @Override
    public void onReceive(Object message) {
        if (message instanceof String) {
            String msg = (String) message;
            if (msg.equals("start")) {
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
        } else {
            unhandled(message);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Main thread starting.");
        ActorSystem system = ActorSystem.create("mySystem");
        ActorRef thread1 = system.actorOf(Props.create(AkkaExample.class, "Thread 1"));
        ActorRef thread2 = system.actorOf(Props.create(AkkaExample.class, "Thread 2"));
        thread1.tell("start", null);
        thread2.tell("start", null);
        system.shutdown();//// shut down with `ActorSystemTerminateReason` https://doc.akka.io/docs/akka/current/coordinated-shutdown.html#:~:text=Scala%20copy%20source%2F%2F%20shut%20down%20with%20%60ActorSystemTerminateReason%60%20system.terminate%28%29,UserInitiatedShutdown%20extends%20CoordinatedShutdown.Reason%20val%20done%3A%20Future%5BDone%5D%20%3D%20CoordinatedShutdown%28system%29.run%28UserInitiatedShutdown%29
        System.out.println("Main thread exiting.");
    }
}
