package com.factory.abstractFactory;

public class BmwSportCar implements SportsCar {
    @Override
    public void driver() {
        System.out.println("这是宝马跑车!");
    }
}
