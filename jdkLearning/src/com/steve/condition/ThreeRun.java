package com.steve.condition;

import java.util.concurrent.TimeUnit;

public class ThreeRun {

    public void printB() {
        System.out.println("B");
    }

    public void printA() {
        System.out.println("A");
    }

    public void printC() {
        System.out.println("C");
    }

    public static void main(String[] args) {
        ThreeRun threeRun = new ThreeRun();
        A a = new A(threeRun);
        B b = new B(threeRun);
        C c = new C(threeRun);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }


  static   class A implements Runnable {
        private ThreeRun threeRun;
        public A(ThreeRun threeRun) {
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
        private ThreeRun threeRun;
        public B(ThreeRun threeRun) {
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
        private ThreeRun threeRun;
        public C(ThreeRun threeRun) {
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