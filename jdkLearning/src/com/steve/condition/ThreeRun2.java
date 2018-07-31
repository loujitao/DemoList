package com.steve.condition;

import java.util.concurrent.TimeUnit;

public class ThreeRun2 {

    //用作判断的信号 0执行A，1执行B，2执行C
    private int single=0;

    public synchronized void printB() {
        while (single!=1){
            try {
                //本线程等待  释放锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        //增量，保证顺序性
        single++;
        //通知其他的线程
        notifyAll();
    }

    public synchronized void printA() {
        while (single!=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        single++;
        notifyAll();
    }

    public synchronized void printC() {
        while (single!=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("C");
        //为保证紧接着打印A，将增量清零
        single=0;
        notifyAll();
    }

    public static void main(String[] args) {
        ThreeRun2 threeRun = new ThreeRun2();
        A a = new A(threeRun);
        B b = new B(threeRun);
        C c = new C(threeRun);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }


  static   class A implements Runnable {
        private ThreeRun2 threeRun;
        public A(ThreeRun2 threeRun) {
            this.threeRun = threeRun;
        }

        @Override
        public void run() {
            while (true) {
                threeRun.printA();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class B implements Runnable {
        private ThreeRun2 threeRun;
        public B(ThreeRun2 threeRun) {
            this.threeRun = threeRun;
        }

        @Override
        public void run() {
            while (true) {
                threeRun.printB();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static  class C implements Runnable {
        private ThreeRun2 threeRun;
        public C(ThreeRun2 threeRun) {
            this.threeRun = threeRun;
        }

        @Override
        public void run() {
            while (true) {
                threeRun.printC();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}