package com.steve.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Dragon {

    public void getBall(CyclicBarrier cb,int index){
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"获得"+index+"星龙珠！");
            cb.await();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       final CyclicBarrier cb=new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"集齐七颗龙珠召唤神龙!");
            }
        });
       final Dragon d=new Dragon();

        for (int i=1;i<8;i++){
           final int j=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    d.getBall(cb,j);
                }
            }).start();
        }
        //检测重用性
        for (int i=1;i<8;i++){
            final int j=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
//                   int b= 8/(j-5);
                    d.getBall(cb,j);
                }
            }).start();
        }
    }

}
