package org.saparov.task;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        CompletableFuture.runAsync(() -> {
            foo.first(new Thread());
        });

        CompletableFuture.runAsync(() -> {
            try {
                foo.second(new Thread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture.runAsync(() -> {
            try {
                foo.third(new Thread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(2000);
    }
}
