package singleton.ehan;
/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  10:07
 * @Description: 饿汉模式
 */
public class Singleton1 {
    //实例化好的对象
    private static Singleton1 instance=new Singleton1();
    //私有构造
    private Singleton1(){}
    //共有提供对象的方法
    public static Singleton1 getInstance(){
        return  instance;
    }
}
