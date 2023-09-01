package org.saparov.task;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread threadA = new Thread(() -> {
            foo.first();
        });

        Thread threadB = new Thread(() -> {
            try {
                foo.second();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                foo.third();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });


        threadC.start();
        threadA.start();
        threadB.start();
    }
}