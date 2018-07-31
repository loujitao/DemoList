package singleton.ehan;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  10:07
 * @Description: 饿汉模式
 * 一般来说，单例模式有五种写法：
 * 懒汉、饿汉、双重检验锁、静态内部类、枚举
 */
public class Singleton implements Serializable{
    //实例化好的对象
    // 因为单例的实例被声明成 static 和 final 变量了，
    // 在第一次加载类到内存中时就会初始化，所以创建实例
    // 本身是线程安全的。
    private static final Singleton instance=new Singleton();
    //在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与
    // 本地实体类中的serialVersionUID进行比较，如果相同则认为是一致的，
    // 便可以进行反序列化，否则就会报序列化版本不一致的异常。
    private static final long serialVersionUID=1000L;
    //私有构造
    private Singleton(){
        // 防止反射获取多个对象的漏洞
        if (null != instance) {
            throw new RuntimeException();
        }
    }
    //共有提供对象的方法
    public static Singleton getInstance(){
        return  instance;
    }

    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
