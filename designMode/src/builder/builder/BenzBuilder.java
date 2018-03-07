package builder.builder;

import builder.produce.BenzCar;
import builder.produce.Car;

public class BenzBuilder implements CarBuilder{
    Car car;

    public BenzBuilder() {
        this.car = new BenzCar();
    }

    @Override
    public void buildWheel() {
        System.out.println("生产奔驰轮子！");
    }

    @Override
    public void buildDoor() {
        System.out.println("生产奔驰门！");
    }

    @Override
    public void buildEngine() {
        System.out.println("生产奔驰发动机！");
    }

    @Override
    public Car buildCar() {
        return car;
    }
}
