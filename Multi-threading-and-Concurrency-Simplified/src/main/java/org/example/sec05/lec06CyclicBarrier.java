package org.example.sec05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class A extends Thread {
    CyclicBarrier barrier;

    public A(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("A begins...");
    }
}

class B extends Thread {
    CyclicBarrier barrier;

    public B(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("B begins...");
    }
}

public class lec06CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        new A(barrier).start();

        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {

        }

        new B(barrier).start();
    }
}