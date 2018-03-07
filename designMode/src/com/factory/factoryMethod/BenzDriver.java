package com.factory.factoryMethod;
/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  9:24
 * @Description:工厂角色，与产品一一对应
 */
public class BenzDriver implements  Driver {
    @Override
    public Car driverCar() {
        return  new Benz();
    }
}
