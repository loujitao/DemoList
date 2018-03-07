package builder.builder;


import builder.produce.BmwCar;
import builder.produce.Car;
/**
 * @Author Loujitao
 * @Date 2018/3/7
 * @Time  9:17
 * @Description:实现Builder的接口以构造和装配该产品的各个部件，
 *       定义并明确它所创建的表示，并提供一个检索产品的接口。
 */
public class BmwBuilder implements CarBuilder {

    private Car car;

    public BmwBuilder() {
        this.car=new BmwCar();
    }

    @Override
    public void buildWheel() {
        System.out.println("生产宝马轮子");
    }

    @Override
    public void buildDoor() {
        System.out.println("生产宝马门");
    }

    @Override
    public void buildEngine() {
        System.out.println("生产宝马发动机");
    }

    @Override
    public Car buildCar() {
        return car;
    }
}
