package org.example.sec02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lec08Callable {
    static class MyMath {
        public static int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 10;
        int y = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // Submit a Callable task and use the Future object to fetch the result.
        Future<Integer> integerFuture = executorService.submit(getTask(x, y));

        // do some parallel task
        // Inefficient to simply wait,
        // instead you can release the CPU
        // by calling Thread.yield() inside
        // the while loop.
        while (!integerFuture.isDone()) {
            ; //wait
        }

        // Fetch the result
        Integer res = integerFuture.get();
        System.out.println("Result is :" + res);
    }

    private static Callable<Integer> getTask(int x, int y) {
        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return MyMath.add(x, y);
            }
        };
    }
}