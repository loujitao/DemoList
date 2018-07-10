package com.steve.threads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsTest {

    //main是进程还是线程   运行完毕，发现是线程
    public static void main(String[] args) {
        test01();
        while (true){}

    }


    public static void test01(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        },"t1").start();
    }
}
