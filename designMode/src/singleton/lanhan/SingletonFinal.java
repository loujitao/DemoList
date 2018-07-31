package singleton.lanhan;

import java.io.ObjectStreamException;

/**
 * @Author Loujitao
 * @Date 2018/3/6
 * @Time  10:07
 * @Description: 懒汉模式
 *
 * instance = new Singleton()这句，这并非是一个原子操作，
 * 事实上在 JVM 中这句话大概做了下面 3 件事情。
        1  给 instance 分配内存
        2  调用 Singleton 的构造函数来初始化成员变量
        3  将instance对象指向分配的内存空间（执行完这步
            instance 就为非 null 了）
但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面
的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3
也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线
程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），所
以线程二会直接返回 instance，然后使用，然后顺理成章地报错。

我们只需要将 instance 变量声明成 volatile 就可以了。
 */
public class SingletonFinal {
    //实例化好的对象
    private volatile static SingletonFinal instance=null;
    //私有构造
    private SingletonFinal(){}
    //双重检验锁模式 线程安全
    //可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
    public static SingletonFinal getSingleton(){
        if(instance==null){
            synchronized (SingletonFinal.class){
                if (instance==null){
                    instance=new SingletonFinal();
                }
            }
        }
        return  instance;
    }

    // 防止反序列化获取多个对象的漏洞
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
