package com.factory.factoryMethod;

/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  9:05
 * @Description:具体产品角色：宝马车
 */
public class BMW implements Car {
    @Override
    public void drive() {
        System.out.println("这是宝马车！");
    }
}
