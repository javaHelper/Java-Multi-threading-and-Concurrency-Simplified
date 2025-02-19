package org.example.sec01;

public class Lec02ParallelismApp {

    public static void main(String[] args) {
        Task task = new Task();
        task.start();

        // runs in the Main thread and prints 1500 M's
        for(int i=1; i <= 1500; i++) {
            System.out.print("M");
        }
    }

    static class Task extends Thread {

        // Thread execution begins here.
        public void run() {
            // performs the task i.e. prints 1500 T's
            doTask();
        }

        public void doTask() {
            for(int i=1; i <= 1500; i++) {
                System.out.print("T");
            }
        }
    }

}