package org.saparov.task;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private CountDownLatch countDownLatch1;
    private CountDownLatch countDownLatch2;

    public Foo() {
        this.countDownLatch1 = new CountDownLatch(1);
        this.countDownLatch2 = new CountDownLatch(1);
    }

    public void first(Runnable runnable){
        System.out.print("first");
        countDownLatch1.countDown();
    }

    public void second(Runnable runnable) throws InterruptedException {
        countDownLatch1.await();
        System.out.print("second");
        countDownLatch2.countDown();
    }

    public void third(Runnable runnable) throws InterruptedException {
        countDownLatch2.await();
        System.out.print("third");
    }
}
