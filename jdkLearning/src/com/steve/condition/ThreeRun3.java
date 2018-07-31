package com.steve.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeRun3 {

    private int single=0;
    //Condition是一个接口，在ReentrantLock里有实现
    Lock lock=new ReentrantLock();
    //分别获取三个条件锁
    Condition a=lock.newCondition();
    Condition b=lock.newCondition();
    Condition c=lock.newCondition();

    public  void printB() {
        lock.lock();
        while (single!=1){
            try {
                //相当于Object的wait()
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        single++;
        //相当于nodifyAll()
        c.signal();
        lock.unlock();
    }

    public   void printA() {
        lock.lock();
        while (single!=0){
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        single++;
        b.signal();
        lock.unlock();
    }

    public   void printC() {
        lock.lock();
        while (single!=2){
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("C");
        single=0;
        a.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        ThreeRun3 threeRun = new ThreeRun3();
        A a = new A(threeRun);
        B b = new B(threeRun);
        C c = new C(threeRun);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }


  static   class A implements Runnable {
        private ThreeRun3 threeRun;
        public A(ThreeRun3 threeRun) {
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
        private ThreeRun3 threeRun;
        public B(ThreeRun3 threeRun) {
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
        private ThreeRun3 threeRun;
        public C(ThreeRun3 threeRun) {
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