package com.factory.simpleFactory;

public class TestCar {

    public static void main(String[] args) {
        try {
            Car car = CarFactory.driverCar("benz");
            Car car2 = CarFactory.driverCar("bmw");
            car.drive();
            car2.drive();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
