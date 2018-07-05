package com.steve.concurrentCollection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

    /**   
     * @Author Loujitao  
     * @Date 2018/7/2
     * @Time  10:45  
     * @Description:
     * 不像ArrayBlockingQueue、LinkedBlockingDeque之类的阻塞队列依赖AQS实现并发操作，
     * SynchronousQueue直接使用CAS实现线程的安全访问。它是个没有容量的队列，
     */  
    public static void main(String[] args) throws Exception {
       final BlockingQueue<String> bq=new SynchronousQueue<>();
        //第一种情况 这种直接添加，会出异常Queue full
//        bq.add("steve");
        
        //第二种情况  如果有线程先取，会阻塞着，这样就能放进去
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println( bq.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);
        //可以理解为交接给了等待的线程,不是真正的存放进去了
        bq.put("stevetao");
    }

}
