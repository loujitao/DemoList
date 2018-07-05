package com.steve.jvm;

import java.text.DecimalFormat;

public class ParamsTest01 {

    /**
     * @Author Loujitao
     * @Date 2018/7/5
     * @Time  9:54
     * @Description:
     * 初始化堆的大小  最大   打印GC详情         使用串行收集器       打印命令行标记
     *  -Xms2m   -Xmx10m  -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
     *  调整初始值和最大值，看看GC发生的次数有什么变化  -Xms2m -Xmx10m；5-10 ；1-10；5-5
     *                                                      9次；9次；10次；9次;
     */
    public static void main(String[] args) throws Exception{
        for(int i=1;i<10;i++){
//            byte[] bytes=new byte[1024*1024];
            byte[] bytes=new byte[1000*1000];
            System.out.println("系统分配了1M空间！");
            jvmInfo();
            Thread.sleep(1000);
        }

    }
    //打印当前最大内存数、空闲内存和总内存
    private static void jvmInfo(){
        long MaxMenory=Runtime.getRuntime().maxMemory();
        System.out.println("最大内存数："+MaxMenory+"KB，即"+format(MaxMenory));
        long freeMenory=Runtime.getRuntime().freeMemory();
        System.out.println("空闲内存数："+freeMenory+"KB，即"+format(freeMenory));
        long totalMemory=Runtime.getRuntime().totalMemory();
        System.out.println("总内存数："+totalMemory+"KB，即"+format(totalMemory));
    }
    //将字节转化为M单位，并保留两位小数
    private static String format(long memory){
        float num=memory/(1024*1024.0f);
        DecimalFormat df=new DecimalFormat("0.00");
        String s=df.format(num)+"MB";
        return s;
    }
}
