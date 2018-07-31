package com.steve.jucUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public void printName(Semaphore sh){
        try {
            sh.acquire();
            System.out.println("当前运行的线程为："+Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            sh.release();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Semaphore semaphore=new Semaphore(5,true);
//        final Semaphore semaphore=new Semaphore(5);  //非公平的
        final SemaphoreTest sht=new SemaphoreTest();
        //每次只能进入5个线程，每次等一秒，这里有100个线程，大致是20S的时间
        Long startTime=System.currentTimeMillis();
        for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sht.printName(semaphore);
                }
            }).start();
        }
        //自旋等待所有线程执行完毕
        // 当前线程组中，主线程存活，另外一个我猜测应该是维护semaphore的线程。
        while (Thread.activeCount()>2){
        }
        Long endTime=System.currentTimeMillis();
        System.out.println("总计："+(endTime - startTime));
    }


}
