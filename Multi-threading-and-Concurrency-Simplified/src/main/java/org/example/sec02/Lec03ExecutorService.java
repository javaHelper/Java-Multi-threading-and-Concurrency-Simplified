package org.example.sec02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lec03ExecutorService {
    public static void main(String[] args) {
        String sourceFile1 = "a.txt";
        String sourceFile2 = "b.txt";

        String destFile1 = "c.txt";
        String destFile2 = "d.txt";

        // Creates a fixed thread pool of size 5.
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(new CopyTask(sourceFile1, destFile1));
        executor.execute(new CopyTask(sourceFile2, destFile2));
    }
}