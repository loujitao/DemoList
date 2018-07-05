package singleton.lanhan;

/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  10:07
 * @Description: 懒汉模式
 */
public class Singleton {
    //实例化好的对象
    private volatile static Singleton instance=null;
    //私有构造
    private Singleton(){}
    //线程不安全
    public  static Singleton getInstances(){
        if (instance==null)  instance=new Singleton();
        return  instance;
    }

    //共有提供对象的方法,线程安全 但是多线程时，其实只需要初始化的时候阻塞就行
    public static synchronized Singleton getInstance(){
        //如果已经初始化了，每次获得对象的时候都阻塞，影响性能
        if (instance==null)  instance=new Singleton();
        return  instance;
    }

    //双重检验锁模式 线程安全
    //可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
    public static Singleton getSingleton(){
        if(instance==null){
            //配合voliate关键字，保证变量在线程间的可见性  线程、单独副本
            synchronized (instance){
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return  instance;
    }
}
