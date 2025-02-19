package org.example.sec02;

public class Lec01DesigningThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.print("T");
            }
        }
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.print("-");
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        MyTask task = new MyTask();
        Thread thread1 = new Thread(task);
        thread1.start();

        for (int i = 0; i <= 1000; i++) {
            System.out.print("M");
        }
    }


}