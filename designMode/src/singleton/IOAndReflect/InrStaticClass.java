package singleton.IOAndReflect;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author Loujitao  
 * @Date 2018/7/10
 * @Time  15:35  
 * @Description:
 * 静态内部类是《effective java》推荐的方法。比起饿汉模式的好处是
 * 静态内部类是私有的属性，只有在getInstance()方法里调用，如果我们不用的
 * 话，他是不会再内存中给我们分配外部类的实例，也就不会再加载类的时候就占用
 * 内存空间。即按需创建实例。
 */  
public class InrStaticClass implements Serializable{
    //私有的构造函数
    private InrStaticClass(){
        //防止反射获取多个对象的漏洞
        if (null != InstanceFactory.ISC)
            throw new RuntimeException();
        System.out.println("实例化了外部类！");
    };
    //共有静态的返回实例方法
    public static InrStaticClass getInstance(){
        return InstanceFactory.ISC;
    }
    public static void printA(){
        System.out.println("A");
    }
    // 防止反序列化获取多个对象的漏洞
    private Object readResolve() throws ObjectStreamException {
        return InstanceFactory.ISC;
    }
    //私有的静态内部类
    private static class InstanceFactory{
        private static InrStaticClass ISC=new InrStaticClass();
        //内部类没有实例化  这个方法无法执行
        public InstanceFactory() {
            System.out.println("内部类实例化了...");
        }
    }

}
