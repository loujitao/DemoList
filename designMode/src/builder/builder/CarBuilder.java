package builder.builder;

import builder.produce.Car;
/**   
 * @Author Loujitao  
 * @Date 2018/3/7
 * @Time  9:17  
 * @Description:为创建一个产品对象的各个部件指定抽象接口。
 */  
public interface CarBuilder {
    void buildWheel();//轮子
    void  buildDoor();//门
    void  buildEngine();//发动机
    Car buildCar();
}
