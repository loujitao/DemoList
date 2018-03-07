package com.factory.abstractFactory;
/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  9:59
 * @Description: 结构清晰，复杂度高，不便于拓展
抽象工厂模式的优点
抽象工厂模式除了具有工厂方法模式的优点外，
最主要的优点就是可以在类的内部对产品族进行
约束。所谓的产品族，一般或多或少的都存在一
定的关联，抽象工厂模式就可以在类内部对产品
族的关联关系进行定义和描述，而不必专门引入
一个新的类来进行管理。

抽象工厂模式的缺点
产品族的扩展将是一件十分费力的事情，假如产品
族中需要增加一个新的产品，则几乎所有的工厂类
都需要进行修改。所以使用抽象工厂模式时，对产
品等级结构的划分是非常重要的。
 */
public class TestCar {

    public static void main(String[] args) {
        //确定生产工厂  将产品分类
        Factory factory=new BenzCarFactory();
        //生产产品
        SportsCar scar=factory.driverSportCar();
        BussinessCar bcar=factory.driverBussinessCar();
        //使用
        scar.driver();
        bcar.driver();
    }
}
