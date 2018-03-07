package singleton.ehan;
/**   
 * @Author Loujitao  
 * @Date 2018/3/6
 * @Time  10:30  
 * @Description:
 * 静态内部类的方法,这种方法也是《Effective Java》上所推荐的。
 */  
public class Singleton2 {
    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }
    private Singleton2 (){}
    public static final Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
