package singleton.ehan;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author Loujitao  
 * @Date 2018/3/6
 * @Time  10:30  
 * @Description:
 * 静态内部类的方法,这种方法也是《Effective Java》上所推荐的。
 */  
public class Singleton2 implements Serializable{
    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static final Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private Singleton2() {
        // 防止反射获取多个对象的漏洞
        if (null != SingletonHolder.INSTANCE)
            throw new RuntimeException();
        System.out.println("外部类序列化...");
    }
    // 防止反序列化获取多个对象的漏洞
    private Object readResolve() throws ObjectStreamException {
        return SingletonHolder.INSTANCE;
    }
}
