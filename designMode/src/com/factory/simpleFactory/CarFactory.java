package com.factory.simpleFactory;
/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  9:06
 * @Description: 工厂类角色
 */
public class CarFactory {

    public  static Car driverCar(String s) throws Exception{
        if (s.equalsIgnoreCase("Benz")) {
            return new Benz();
        }else if (s.equalsIgnoreCase("BMW")) {
            return new BMW();
        }else {
            throw new Exception();
        }
    }
}
