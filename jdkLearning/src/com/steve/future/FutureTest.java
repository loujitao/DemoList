package com.steve.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTest {

    public static void main(String[] args) {
        //方式一  FutureTask(Callable<V> callable)
        Callable<Integer> call=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("正在处理计算结果...");
                TimeUnit.SECONDS.sleep(1);
                return 27;
            }
        };
        //方式二   FutureTask(Runnable runnable, V result)
        Runnable run=new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("处理完毕...");
            }
        };
//        FutureTask<Integer> task=new FutureTask<Integer>(call);  //方式一
        FutureTask<Integer> task=new FutureTask<Integer>(run,27);//方式二
        new Thread(task).start();

        System.out.println("其他的任务处理中...");
        try {
            Integer result=task.get();
            System.out.println("获得计算结果"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
