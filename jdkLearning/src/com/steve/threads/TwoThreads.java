package com.steve.threads;
/**
 * @Author Loujitao
 * @Date 2018/6/14
 * @Time  16:22
 * @Description:
 * 线程多用接口，而不是内部类。有几下几个原因：
 * 1、thread自身是runnable接口的实现类；如果线程类里面设置线程任务类，优先执行thread累里的run()
 * 2、继承为单继承，接口能多实现。复用性接口较优
 */
public class TwoThreads {

    public static void main(String[] args) {
        //问题1：Thread是Runnable的实现类，重写了run方法。
        // 加载的时候会先找下面的run1；
        //如果没有重写的run的话，会找Thread的元run方法，里面调用的是Runnable的run3
        new Thread(new Runnable() {
                    @Override       //run3
                    public void run() {
                        System.out.println("这是Runnable的run方法！");
                    }
                }
            ){
            @Override     //run1
            public void run() {
                System.out.println("这是线程自身的run方法！");
            }
        }.start();
        //--------------手动分割线--------------------
        new Thread(new Runnable() {
            @Override       //run3
            public void run() {
                System.out.println("这是Runnable的run方法！");
            }
        }
        ){
             //这次没有重写Thread自身的run()
        }.start();

        //问题2：大概是这样
//        MyThreeds threed1=new MyThreeds();
//        MyThreeds threed2=new MyThreeds();
//        MyThreeds threed3=new MyThreeds();

//       Runnable runnable1= new MyThreeds2();
//                runnable1=new MyThreeds3();
//                runnable1=new MyThreeds4();
//        Thread thread1=new Thread(runnable1);
    }

//继承方式的线程类
    class MyThreeds extends Thread{
        @Override
        public void run() {
            long i=System.currentTimeMillis();
            System.out.println("name:"+Thread.currentThread().getName()+"开始执行！");
            while (System.currentTimeMillis()-i<10000){
                //空循环10s  Thread.sleep(10s);
            }
            System.out.println("name:"+Thread.currentThread().getName()+"执行结束！");
        }
    }
//接口实现类方式的线程任务类
    class MyThreeds2 implements Runnable{
        @Override
        public void run() {
            long i=System.currentTimeMillis();
            System.out.println("name2:"+Thread.currentThread().getName()+"开始执行！");
            while (System.currentTimeMillis()-i<10000){
                //空循环10s  Thread.sleep(10s);
            }
            System.out.println("name2:"+Thread.currentThread().getName()+"执行结束！");
        }
    }


}
