package com.syc.eurekaclient.hystrix;

import java.util.concurrent.*;

/**
 * 线程池监控
 */
public class ThreadPoolTest {


    private static ExecutorService es = new ThreadPoolExecutor(50, 100, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100000));

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            es.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);

        while (true) {
            System.out.println();

            int queueSize = tpe.getQueue().size();
            System.out.println("当前排队任务数：" + queueSize);

            int activeCount = tpe.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = tpe.getCompletedTaskCount();
            System.out.println("执行完成任务数：" + completedTaskCount);

            long taskCount = tpe.getTaskCount();
            System.out.println("总线任务数：" + taskCount);

            Thread.sleep(3000);
        }

    }

    public String test() {


        Semaphore semaphore = new Semaphore(1, true);


        return super.toString();
    }
}
