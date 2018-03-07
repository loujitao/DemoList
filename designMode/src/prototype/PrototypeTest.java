package prototype;
/**
 * @Author Loujitao
 * @Date 2018/3/7
 * @Time  9:37
 * @Description:使用原型模式创建对象比直接new一个对象在性能上要好的多，
 * 因为Object类的clone方法是一个本地方法，它直接操作内存中的二进制流，特别是
 * 复制大对象时，性能的差别非常明显。
 */
public class PrototypeTest {

    public static void main(String[] args) {
        ConcretePrototype cp=new ConcretePrototype();
        ConcretePrototype cloneCP=(ConcretePrototype) cp.clone();
        cp.toPrint();
        cloneCP.toPrint();
        System.out.println(cp);
        System.out.println(cloneCP);
    }
}
