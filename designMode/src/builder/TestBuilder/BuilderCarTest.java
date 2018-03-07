package builder.TestBuilder;

import builder.builder.BenzBuilder;
import builder.builder.BmwBuilder;
import builder.director.CarDirector;
import builder.produce.Car;

public class BuilderCarTest {
    public static void main(String[] args) {
        CarDirector cd=new CarDirector();//指导者
        Car benzCar=cd.constructCar(new BenzBuilder());
        Car bmwCar=cd.constructCar(new BmwBuilder());
    }
}
