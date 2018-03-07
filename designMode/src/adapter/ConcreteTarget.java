package adapter;
/**
 * @Author Loujitao
 * @Date 2018/3/7
 * @Time  9:44
 * @Description:具体目标类，只提供普通功能
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }
}
