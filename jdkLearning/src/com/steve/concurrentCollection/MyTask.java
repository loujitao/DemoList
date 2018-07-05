package com.steve.concurrentCollection;

public class MyTask implements Comparable<MyTask> {

    private int money;
    private String name;
    @Override
    public int compareTo(MyTask o) {
        return this.money>o.money?-1:(this.money==o.money?0:1);
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "money=" + money +
                ",name=" + name +" ";
    }
}
