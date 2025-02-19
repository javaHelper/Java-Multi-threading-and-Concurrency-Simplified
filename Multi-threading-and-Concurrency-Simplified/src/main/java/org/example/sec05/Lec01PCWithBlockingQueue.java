package org.example.sec05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerThread extends Thread {
    BlockingQueue<String> queue;

    public ProducerThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String msg = "Hello-" + i;
            try {
                queue.put(msg);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Produced - " + msg);
        }
    }
}

class ConsumerThread extends Thread {
    BlockingQueue<String> queue;

    public ConsumerThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String message;
            try {
                message = queue.take();
                System.out.println("Consumed - " + message);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

public class Lec01PCWithBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        new ProducerThread(queue).start();
        new ConsumerThread(queue).start();
    }
}