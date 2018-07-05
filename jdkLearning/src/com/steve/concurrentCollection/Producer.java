package com.steve.concurrentCollection;

import java.util.concurrent.BlockingQueue;
/**
 * @Author Loujitao
 * @Date 2018/6/27
 * @Time  17:42
 * @Description:
 */
public class Producer implements Runnable{

    private BlockingQueue MQList=null;

    public Producer(BlockingQueue MQList) {
        this.MQList = MQList;
    }

    @Override
    public void run() {
        try {
            for (int a=1;a<10;a++){
                //这里我让线程休眠0.5s，因为保存数据到数据库或者操作数据都是耗时的
//                Thread.sleep(500);
                Thread.sleep(2000);
                String str=Thread.currentThread().getName();
                MQList.put(str+"的"+a);
                System.out.println("生产者"+str+"存放了"+a);
            }
            System.out.println("生产者生产完成消息了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
