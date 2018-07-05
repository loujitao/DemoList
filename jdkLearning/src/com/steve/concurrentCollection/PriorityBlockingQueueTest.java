package com.steve.concurrentCollection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
    
    /**   
     * @Author Loujitao  
     * @Date 2018/7/2
     * @Time  9:58  
     * @Description: https://blog.csdn.net/qq_38872310
     */  
    public static void main(String[] args)throws Exception {
        BlockingQueue<MyTask> bq=new PriorityBlockingQueue<MyTask>();

        MyTask t0=new MyTask();
        t0.setMoney(0);
        t0.setName("VIP LV0");
        MyTask t1=new MyTask();
        t1.setMoney(1);
        t1.setName("VIP LV1");
        MyTask t2=new MyTask();
        t2.setMoney(2);
        t2.setName("VIP LV2");
        MyTask t3=new MyTask();
        t3.setMoney(3);
        t3.setName("VIP LV3");
        //这里我特意打乱了顺序
        bq.add(t2);
        bq.add(t1);
        bq.add(t3);
        bq.add(t0);
        //优先级最高的先执行了，这里t3的VIP等级高先走了
        //优先级队列，只有调用一次take()方法，才会进行排序
        System.out.println(bq.take());
        System.out.println(bq);
    }

}
