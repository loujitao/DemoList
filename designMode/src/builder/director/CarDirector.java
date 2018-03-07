package builder.director;

import builder.builder.CarBuilder;
import builder.produce.Car;
/**
 * @Author Loujitao
 * @Date 2018/3/7
 * @Time  9:16
 * @Description:构造一个使用Builder接口的对象，指导构建过程。
 * 隐藏了构建的细节
 */
public class CarDirector {
    public Car constructCar(CarBuilder cb){
        cb.buildWheel();
        cb.buildDoor();
        cb.buildEngine();
        return  cb.buildCar();
    }
}
