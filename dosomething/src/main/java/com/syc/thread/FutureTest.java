package com.syc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTest {


    public static void main(String[] args) {

        Callable<String> callable = () -> {
            Thread.sleep(10000);
            System.out.println("睡醒了");
            return null;
        };

        FutureTask<String> task = new FutureTask<>(callable);
        task.run();

        for (; ; ) {
            if (task.isDone()) {
                System.out.println("开始干活");
                break;
            }
        }
        System.out.println("working ...");

    }
}
