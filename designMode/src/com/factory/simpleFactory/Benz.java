package com.factory.simpleFactory;
/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  9:04
 * @Description:具体产品角色：奔驰车
 */
public class Benz implements Car {
    @Override
    public void drive() {
        System.out.println("这是奔驰车！");
    }
}
