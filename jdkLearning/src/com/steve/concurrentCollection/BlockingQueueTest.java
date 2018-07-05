package com.steve.concurrentCollection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
//        function01();
        function02();
    }

    /**
     * @Author Loujitao
     * @Date 2018/6/27
     * @Time  17:44
     * @Description: ArrayBlockingQueue的底层使用的是ReentrantLock重入锁
     *   而且是默认false，然后走sync = fair ? new FairSync() : new NonfairSync();的非公平锁
     */
    public static void function01(){
        BlockingQueue bq=new ArrayBlockingQueue(5);
        //producer是一个线程任务类，执行的方法是往队列里放10条数据
        Producer producer=new Producer(bq);
        Producer producer2=new Producer(bq);
        //consumer是线程任务类，执行方法是往队列里拿数据   他两的队列是同一个队列，
        Cunsumer cunsumer=new Cunsumer(bq);
        Cunsumer cunsumer2=new Cunsumer(bq);

        new Thread(producer,"pro1").start();
//        new Thread(producer2,"pro2").start();
        new Thread(cunsumer,"cunsumer01").start();
        new Thread(cunsumer2,"cunsumer02").start();
    }

    public static void function02(){
        BlockingQueue bq=new LinkedBlockingQueue();
        //producer是一个线程任务类，执行的方法是往队列里放10条数据
        Producer producer=new Producer(bq);
        Producer producer2=new Producer(bq);
        //consumer是线程任务类，执行方法是往队列里拿数据   他两的队列是同一个队列，
        Cunsumer cunsumer=new Cunsumer(bq);

        new Thread(producer,"pro1").start();
        new Thread(producer2,"pro2").start();
        new Thread(cunsumer,"me").start();
    }


}
