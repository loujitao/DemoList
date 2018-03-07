package singleton.lanhan;

/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  10:07
 * @Description: 懒汉模式
 */
public class Singleton {
    //实例化好的对象
    private static Singleton instance=null;
    //私有构造
    private Singleton(){}
    //线程不安全
    public  static Singleton getInstances(){
        if (instance==null)  instance=new Singleton();
        return  instance;
    }

    //共有提供对象的方法  线程安全
    public static synchronized Singleton getInstance(){
        if (instance==null)  instance=new Singleton();
        return  instance;
    }

    //双重检验锁模式 线程安全
    //可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
    public static Singleton getSingleton(){
        if(instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return  instance;
    }
}
