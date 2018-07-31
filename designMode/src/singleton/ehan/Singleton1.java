package singleton.ehan;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  10:07
 * @Description: 饿汉模式
 */
public class Singleton1 implements Serializable{
    //实例化好的对象
    private static Singleton1 instance=new Singleton1();
    //私有构造
    private Singleton1(){
        // 防止反射获取多个对象的漏洞
        if (null != instance) {
            throw new RuntimeException();
        }
    }
    //共有提供对象的方法
    public static Singleton1 getInstance(){
        return  instance;
    }

    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
