package com.syc.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch doneSignal = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new WorkerRunnable(doneSignal, i));
        }
        doneSignal.await();

        System.out.println("done!");
        executorService.shutdown();
    }
}

class WorkerRunnable implements Runnable {
    private final CountDownLatch downLatch;
    private final int i;

    public WorkerRunnable(CountDownLatch downLatch, int i) {
        this.downLatch = downLatch;
        this.i = i;
    }


    @Override
    public void run() {
        try {
            doWork(i);
            downLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void doWork(int i) throws InterruptedException {
        System.out.println("worker [" + (i + 1) + "] start work");
        Thread.sleep(1000);
    }
}


