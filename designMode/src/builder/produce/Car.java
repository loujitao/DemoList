package builder.produce;
/**
 * @Author Loujitao
 * @Date 2018/3/7
 * @Time  9:18
 * @Description:表示被构造的复杂对象。
 * ConcreteBuilder创建该产品的内部表示并定义
 * 它的装配过程，包含定义组成部件的类，包括将
 * 这些部件装配成最终产品的接口。
 */
public class Car {
    private String wheel;
    private String door;
    private  String engine;

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
