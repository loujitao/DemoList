package com.factory.abstractFactory;

public class BenzBussinesCar implements BussinessCar {
    @Override
    public void driver() {
        System.out.println("这是奔驰商务车！");
    }
}
