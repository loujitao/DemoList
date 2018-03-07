package singleton.ehan;
/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  10:07
 * @Description: 饿汉模式
 * 一般来说，单例模式有五种写法：
 * 懒汉、饿汉、双重检验锁、静态内部类、枚举
 */
public class Singleton {
    //实例化好的对象
    // 因为单例的实例被声明成 static 和 final 变量了，
    // 在第一次加载类到内存中时就会初始化，所以创建实例
    // 本身是线程安全的。
    private static final Singleton instance=new Singleton();
    //私有构造
    private Singleton(){}
    //共有提供对象的方法
    public static Singleton getInstance(){
        return  instance;
    }
}
