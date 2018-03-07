package com.factory.factoryMethod;

public class TestCar {
    public static void main(String[] args) {
        try {
            //先有具体工厂角色
            Driver driver=new BenzDriver();
            Driver driver2=new BmwDriver();
            //生产对应的产品
            Car car=driver.driverCar();
            Car car2=driver2.driverCar();
            //使用
            car.drive();
            car2.drive();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
