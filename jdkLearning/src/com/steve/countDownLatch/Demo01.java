package com.steve.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {

    public static void main(String[] args) {
        int a=5;
        CountDownLatch signal=new CountDownLatch(a);
        for (int i=0;i<a;i++){
            //for循环必须调用五次countDown
             new Thread(new Runner(signal,i+"号选手")).start();
        }
        try {
            //让所有的线程先阻塞着，等countDown清零了，才能放行
            signal.await();
            System.out.println("比赛结束...");
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    static class Runner implements Runnable{
        private final CountDownLatch doSignal ;
        private final String runnerName;
        Runner(CountDownLatch c,String name){
            this.doSignal=c;
            this.runnerName=name;
        }
        @Override
        public void run() {
            try {
                prepare(runnerName);
                //倒计时器
                doSignal.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void prepare(String name){
            System.out.println("运动员"+name+"抵达终点！");
        }
    }
}
