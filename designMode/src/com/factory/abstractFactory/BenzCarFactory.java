package com.factory.abstractFactory;

public class BenzCarFactory implements Factory {
    @Override
    public SportsCar driverSportCar() {
        return new BenzSprotCar();
    }

    @Override
    public BussinessCar driverBussinessCar() {
        return new BenzBussinesCar();
    }
}
