package com.steve.jucUtils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {
    private static  String steve=null;
    private static String tao=null;

    public void  a(Exchanger<String> exchanger){
        steve="steve";
        try {
            //把交换来的数据替换本身的数据
            System.out.println("steve ="+steve);
           steve= exchanger.exchange(steve);
            System.out.println("a 交换数据完成！时间："+System.currentTimeMillis());
            //等待模拟延迟和处理耗费的时间
            TimeUnit.SECONDS.sleep(1);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
    public void  b(Exchanger<String> exchanger){
        tao="tao";
        try {
            //把交换来的数据替换本身的数据
            System.out.println("tao ="+tao);
           tao=exchanger.exchange(tao);
            System.out.println("b 交换数据完成！时间："+System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        final Exchanger<String> exchanger=new Exchanger<>();
        final ExchangerTest test=new ExchangerTest();
       Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                test.a(exchanger);
            }
        });
       Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                test.b(exchanger);
            }
        });
       t1.start();
       t2.start();
       //等t1 t2线程执行结束，不然数据没有交换完毕
       while (t1.isAlive() || t2.isAlive() ){}

        System.out.println("steve :"+steve);
        System.out.println("tao :"+tao);
    }

}
