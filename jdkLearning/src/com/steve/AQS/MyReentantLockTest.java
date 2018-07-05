package com.steve.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyReentantLockTest {

    private  int number=0;
    private MyLock myLock=new MyLock();

    public static void main(String[] args) {
        final MyReentantLockTest mtest=new MyReentantLockTest();
       /*new Thread(new Runnable() {
           @Override
           public void run() {
               while (true){
                   mtest.getnext();
               }
           }
       }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mtest.getnext();

                }
            }
        }).start();*/

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
////                    mtest.getnext();
//                    mtest.saftNext();
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
////                    mtest.getnext();
//                    mtest.saftNext();
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
////                    mtest.getnext();
//                    mtest.saftNext();
//                }
//            }
//        }).start();
        mtest.printA();
    }

    public  void getnext(){
        try {
            System.out.println(Thread.currentThread().getId()+"  "+ number++);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saftNext(){
        myLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId()+"  "+ number++);
        }catch (Exception e){
           throw  new RuntimeException();
        }finally {
            myLock.unlock();
        }
    }

    public void printA(){
            myLock.lock();
            System.out.println("A");
            printB();
            myLock.unlock();
    }
    public void printB(){
            myLock.lock();
            System.out.println("B");
            myLock.unlock();
    }

}
