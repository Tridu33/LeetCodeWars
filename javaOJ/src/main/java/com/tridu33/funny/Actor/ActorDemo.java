package com.tridu33.funny.Actor;
import java.util.concurrent.CountDownLatch;
/*
        <dependency>
            <groupId>com.typesafe.akka</groupId>
            <artifactId>akka-actor_2.10</artifactId>
            <version>2.3.16</version>
        </dependency>
        <dependency>
            <groupId>org.scala-lang</groupId>
            <artifactId>scala-actors</artifactId>
            <version>2.11.12</version>
        </dependency>
* */
import akka.actor.UntypedActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import scala.concurrent.Future;

class BankActor extends UntypedActor {
    private int count;

    @Override
    public void preStart() throws Exception {
        super.preStart();
        count = 0;
    }

    @Override
    public void onReceive(Object message) {
        // 可以使用枚举或者动态代理类来实现方法调用
        if (message instanceof Command) {
            Command cmd = (Command) message;
            switch (cmd) {
                case ADD:
                    System.out.println("Add 1 from " + count + " to " + ++count);
                    break;
                case MINUS:
                    System.out.println("Minus 1 from " + count + " to " + --count + "");
                    break;
                case GET:
                    System.out.println("Return current count " + getSender());
                    getSender().tell(count, this.getSelf());
                    break;
                default:
                    System.out.println("UnSupport cmd: " + cmd);
            }
        } else {
            System.out.println("Discard unknown message: " + message);
        }
    }
}

enum Command {
    ADD,
    MINUS,
    GET
}


public class ActorDemo {
    //  @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        final ActorSystem actorSystem = ActorSystem.create("actor-system");

        final ActorRef actorRef = actorSystem.actorOf(Props.create(BankActor.class), "bank-actor");

        CountDownLatch addCount = new CountDownLatch(20);
        CountDownLatch minusCount = new CountDownLatch(10);

        Thread addCountT = new Thread(new Runnable() {
            @Override
            public void run() {
                while (addCount.getCount() > 0) {
                    // 仅仅是使用Actor模型的层次上，只需要理解到扔到邮箱通知队列中，
                    actorRef.tell(Command.ADD, null);
                    addCount.countDown();
                }
            }
        });

        Thread minusCountT = new Thread(new Runnable() {
            @Override
            public void run() {
                while (minusCount.getCount() > 0) {
                    actorRef.tell(Command.MINUS, null);
                    minusCount.countDown();
                }
            }
        });

        minusCountT.start();
        addCountT.start();
        minusCount.await();
        addCount.await();

        Future<Object> count = Patterns.ask(actorRef, Command.GET, 1000);
        while (true) {
            if (count.isCompleted()) {
                break;
            }
        }
        System.out.println(count.value());
//        final Timeout timeout = new Timeout(Duration.create(3, TimeUnit.SECONDS));
//        Integer res = (Integer) Await.result(count,timeout.duration());
//        System.out.println(res);
        actorSystem.shutdown();
    }
}
