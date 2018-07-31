package com.steve.countDownLatch;

import javafx.concurrent.Worker;

import java.util.concurrent.CountDownLatch;

public class Demo02 {

    public static void main(String[] args) {
        //开关
        CountDownLatch startSignal = new CountDownLatch(1);
        for (int i = 0; i < 5; ++i)
            new Thread(new Worker(startSignal, i+"号选手")).start();

            System.out.println("准备，3、2、1...");
            //打开开关
            startSignal.countDown();
            System.out.println("开始！");

    }

    static  class Worker implements Runnable{
        private final CountDownLatch startSignal;
        private final  String name;
        Worker(CountDownLatch startSignal, String name) {
            this.startSignal = startSignal;
            this.name=name;
        }
        @Override
        public void run() {
            try {
                //开关关闭
                startSignal.await();
                doWork(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doWork(String name){
            System.out.println(name+"开始起跑...");
        }
    }

}
