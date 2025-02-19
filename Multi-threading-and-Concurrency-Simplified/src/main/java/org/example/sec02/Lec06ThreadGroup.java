package org.example.sec02;

public class Lec06ThreadGroup {
    public static void main(String[] args) {
        System.out.println("System threads..........");
        Thread thr = Thread.currentThread();
        ThreadGroup grp = thr.getThreadGroup();
        while (grp.getParent() != null) {
            grp = grp.getParent();
        }
        grp.list();
    }
}