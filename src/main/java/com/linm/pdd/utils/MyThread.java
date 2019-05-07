package com.linm.pdd.utils;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread {

    //private static ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();


    public static void main(String[] args)  {
        ExecutorService cachedThreadPool=Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool=Executors.newFixedThreadPool(3);
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        String s = "today is monday";
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i< 10000; i++) {
            int k = i;
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    MyThread.printA(k,s);
                }
            });
        }
        System.out.println(System.currentTimeMillis()-timeStart);
        fixedThreadPool.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printA(int index,String s){
        System.out.println(index+":"+s);
    }
}
