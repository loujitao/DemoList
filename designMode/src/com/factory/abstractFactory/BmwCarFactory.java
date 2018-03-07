package com.factory.abstractFactory;

public class BmwCarFactory implements Factory {
    @Override
    public SportsCar driverSportCar() {
        return new BmwSportCar();
    }

    @Override
    public BussinessCar driverBussinessCar() {
        return new BmwBussinessCar();
    }
}
