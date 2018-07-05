package com.steve.concurrentCollection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class LOLGamer implements Delayed {

    private String name;
    //上机座位号
    private String id;
    //截止时间
    private long endTime;
    //定义时间工具类
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public LOLGamer(String name, String id, long endTime) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }
    @Override
    public int compareTo(Delayed o) {
        LOLGamer lg=(LOLGamer) o;
        return this.getDelay(this.timeUnit)-o.getDelay(this.timeUnit)>0?1:0;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return endTime-System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
