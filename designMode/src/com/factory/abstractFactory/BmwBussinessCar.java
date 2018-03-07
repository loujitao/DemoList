package com.factory.abstractFactory;

public class BmwBussinessCar implements BussinessCar {
    @Override
    public void driver() {
        System.out.println("这是宝马商务车！");
    }
}
