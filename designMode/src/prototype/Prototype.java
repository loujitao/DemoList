package prototype;
/**   
 * @Author Loujitao  
 * @Date 2018/3/7
 * @Time  9:32  
 * @Description:原型模式是一种比较简单的模式，也非常容易理解，
 *                  实现一个接口，重写一个方法即完成了原型模式
 */  
public abstract class Prototype implements Cloneable {

    public Prototype clone() {
        Prototype prototype=null;
        try {
            prototype=(Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }

}
