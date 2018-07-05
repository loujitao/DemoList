package com.steve.jvm;

import java.text.DecimalFormat;

public class ParamsTest02 {

    /**
     * @Author Loujitao
     * @Date 2018/7/5
     * @Time  9:54
     * @Description:  Xmn（一般设置为Xmx的1/3）
     * 初始化堆的大小  最大 新生代大小  eden区和from/to空间的比例   打印GC      使用串行收集器
     *   -Xms10m      -Xmx10m    -Xmn3m  -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
     *  调整新生代值，看看GC发生的次数有什么变化  1m; 2m; 3m;5m；6m
     *                                             4次；3次/2次；4次；2次;2次
     *  低于5M时，使用了老年代的堆内存，所以导致GC次数异常
     */
    public static void main(String[] args) throws Exception{
        for(int i=1;i<5;i++){
            byte[] bytes=new byte[1024*1024];
            System.out.println("系统分配了1M空间！");
            Thread.sleep(1000);
        }

    }

}
