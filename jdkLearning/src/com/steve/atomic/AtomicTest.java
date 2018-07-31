package com.steve.atomic;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private AtomicInteger count=new AtomicInteger(0);


    public Integer getCount() {
        return count.get();
    }

    public void setCount(Integer count) {
        this.count.addAndGet(count);
    }

    public static void main(String[] args) {
        final UnsafeCount ufc=new UnsafeCount();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<100;i++) {
                    ufc.setCount(1);
                }
                System.out.println(Thread.currentThread().getName() + "获取值为：" + ufc.getCount());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<100;i++) {
                    ufc.setCount(1);
                }
                System.out.println(Thread.currentThread().getName() + "获取值为：" + ufc.getCount());
            }
        }).start();
        while (Thread.activeCount()>2){}
        System.out.println(Thread.currentThread().getName() + "获取值为：" + ufc.getCount());
    }
}
