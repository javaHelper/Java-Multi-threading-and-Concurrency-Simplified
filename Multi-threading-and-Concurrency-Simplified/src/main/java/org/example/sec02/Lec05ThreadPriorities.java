package org.example.sec02;

public class Lec05ThreadPriorities {
    static class CopyTask implements Runnable {
        @Override
        public void run() {
            while (true){
                System.out.print("C");
            }
        }
    }

    static class ProgressTask implements Runnable {

        @Override
        public void run() {
            while(true) {
                System.out.print("-");
            }
        }
    }

    public static void main(String[] args) {
        CopyTask copyTask = new CopyTask();

        Thread copyThread = new Thread(copyTask);
        copyThread.setPriority(Thread.NORM_PRIORITY + 3);
        copyThread.start();

        ProgressTask progressTask = new ProgressTask();
        Thread progressThread = new Thread(progressTask);
        progressThread.start();
    }
}