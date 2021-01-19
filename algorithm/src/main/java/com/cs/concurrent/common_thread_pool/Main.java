package com.cs.concurrent.common_thread_pool;

import com.cs.concurrent.common_thread_pool.cfg.Configuration;
import com.cs.concurrent.common_thread_pool.thread.ThreadPool;

public class Main {

    private static Object lock = new Object();

    public static void main(String[] args) {
        //初始化线程池
        ThreadPool tp = new ThreadPool("com.cloudiip.engine.common.biz.impl.MqttBizWorkImpl");
        //创建1000个线程
        tp.bulidThread(Integer.parseInt(Configuration.getConfiguration("thread.pool.size")));

        while(true) {
            synchronized(lock){
                try {
                    lock.wait(); //等待，直到其它线程调用 lock.notify()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
