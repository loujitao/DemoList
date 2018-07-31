package com.steve;

public class threadLocal {

    public static void main(String[] args) {
        //
        final ThreadLocal<Integer> tl1=new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                //给ThreadLocal附上初始值
                return 1;
            }
        };

        new Thread(new Runnable() {
            public void run() {
                while (true){
                Integer a=tl1.get();
                System.out.println(Thread.currentThread().getName()+" "+a);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tl1.set(++a);
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    Integer b = tl1.get();
                    System.out.println(Thread.currentThread().getName() + " " + b);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tl1.set(b + 2);
//                    tl1.set(++b);
                }
            }
        }).start();
//        new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    Integer c = tl1.get();
//                    System.out.println(Thread.currentThread().getName() + " " + c);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    tl1.set(c);
//                }
//            }
//        }).start();


     }

}
