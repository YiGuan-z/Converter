package com.cqsd;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

public class Demo11 {
    static class testClass {
      AtomicLong aLong;
        static long start1;
        static long start2;
        static long endl1;
        static long endl2;
    }

    class serviceClass {
        synchronized void print() {
            try {
                System.out.printf("%-2s开始\n", Thread.currentThread().getName());
                Thread.sleep(3000);
//                synchronized (this) {
                System.out.printf("%-2s处理结算结果\n", Thread.currentThread().getName());
//                }
                System.out.printf("%-2s结束任务\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Demo11Thread {
        private serviceClass service;
        private Runnable runnableA = () -> {
            testClass.start1 = System.currentTimeMillis();
            service.print();
            testClass.endl1 = System.currentTimeMillis();
        };
        private Runnable runnableB = () -> {
            testClass.start2 = System.currentTimeMillis();
            service.print();
            testClass.endl2 = System.currentTimeMillis();
        };

        public Demo11Thread(serviceClass service) {
            this.service = service;
        }

    }

    @Test
    void testThread() throws InterruptedException {
        var serviceClass = new serviceClass();
        Demo11Thread demo11Thread = new Demo11Thread(serviceClass);
        Thread thread = new Thread(demo11Thread.runnableA, "ThreadA");
        Thread thread1 = new Thread(demo11Thread.runnableB, "ThreadB");
        thread.start();
        thread1.start();
        Thread.sleep(10000);
        long startmax = Math.max(testClass.start1, testClass.start2);
        long endMin = Math.max(testClass.endl1, testClass.endl2);
        System.out.printf("总耗时为%d", (endMin - startmax) / 1000);
    }

}
