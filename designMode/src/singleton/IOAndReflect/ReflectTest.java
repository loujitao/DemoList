package singleton.IOAndReflect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) {
        try {
//            test01();
            test02();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author Loujitao
     * @Date 2018/7/11
     * @Time  9:26
     * @Description:
     * 如果私有构造器加了判断，使用反射会抛出异常
     * 这就能解决使用反射破坏单例模式的漏洞
     */
    public static void test01() throws Exception{
        SingletonFinal slf=SingletonFinal.getSingleton();
        System.out.println(slf);
        Class c= Class.forName("singleton.IOAndReflect.SingletonFinal");
        Constructor<SingletonFinal> constructor=c.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        SingletonFinal slf2=constructor.newInstance();
        System.out.println(slf2);
    }

    /**
     * @Author Loujitao
     * @Date 2018/7/11
     * @Time  9:41
     * @Description: 反序列化出来的hash码跟原来的不一致
     * 序列化操作提供了一个很特别的钩子（hook）-类中具有一个私有
     * 的被实例化的方法readresolve(),这个方法可以确保类的开发人员
     * 在序列化将会返回怎样的object上具有发言权。
     *
     * 我们重写的readResolve()是返回单例的实例，因为序列化的时候
     * 肯定实例化了单例对象，所以能确保不为空
     */
    public static void test02() throws Exception{
        SingletonFinal slf=SingletonFinal.getSingleton();
        System.out.println("slf:"+slf);
        // 1. 把对象slf写入硬盘文件
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(slf);
        oos.close();
        fos.close();
        //这里我把单例栈里的引用置空，不能确保堆里的被GC了
        slf=null;
        // 2. 把硬盘文件上的对象读出来
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.out"));
        // 如果对象定义了readResolve()方法，readObject()会调用readResolve()方法。从而解决反序列化的漏洞
        SingletonFinal sc5 = (SingletonFinal) ois.readObject();
        // 反序列化出来的对象，和原对象，不是同一个对象。如果对象定义了readResolve()方法，可以解决此问题。
        System.out.println("sc5:"+sc5);
        ois.close();
    }

}
