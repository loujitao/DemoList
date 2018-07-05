package com.steve.concurrentCollection;

import java.util.concurrent.DelayQueue;

public class GameBar implements  Runnable{

    private DelayQueue<LOLGamer> queue = new DelayQueue<LOLGamer>();
    public boolean yinye =true;

    public void shangji(String name,String id,int money){
        //1000 * money + System.currentTimeMillis()  表示从当前开始上1000ms，截止下机时间就是这个和
        LOLGamer man = new LOLGamer(name, id, 1000 * money + System.currentTimeMillis());
        System.out.println("玩家"+man.getName()+" 机位号"+man.getId()+"交钱"+money+"块,开始上机...");
        //上机同时将消费记录存到延迟队列里
        this.queue.add(man);
    }
    public void xiaji(LOLGamer man){
        System.out.println("玩家"+man.getName()+" 机位号"+man.getId()+"时间到下机...");
    }
    @Override
    public void run() {
        while(yinye){
            try {
                //延迟时间到了，才能获取数据  只有有数据才能取到
                LOLGamer man = queue.take();
                //时间到了的墙纸下机了
                xiaji(man);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        try{
            System.out.println("网鱼网吧欢迎你");
            GameBar wangyu = new GameBar();
            Thread shangwang = new Thread(wangyu);
            shangwang.start();

            wangyu.shangji("张三", "A001", 1);
            wangyu.shangji("李四", "A002", 10);
            wangyu.shangji("王五", "A003", 5);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
