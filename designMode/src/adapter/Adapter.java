package adapter;
/**
 * @Author Loujitao
 * @Date 2018/3/7
 * @Time  9:45
 * @Description:适配器类，继承了被适配类，同时实现标准接口
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}
