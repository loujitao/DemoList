package bright.test;

import bright.color.BaseColor;
import bright.color.BlueColor;
import bright.color.RedColor;
import bright.pen.BasePen;
import bright.pen.BigPen;
import bright.pen.SmallPen;
/**
 * @Author Loujitao
 * @Date 2018/3/12
 * @Time  14:19
 * @Description:
抽象化角色：抽象化给出的定义，并保存一个对实现化对象的引
            用，就是图像类中的形状父类。
修正抽象化角色：扩展抽象化角色，改变和修正父类对抽象化的
            定义，比如形状下有正方形，圆形等图形。
实现化角色：这个角色给出具体角色的接口，但是不给出具体的
            实现，这个接口不一定和抽象化角色的接口定义相同，实际上两
            者可以完全不一样，好比形状的颜色接口。
具体实现化角色：这个角色给出实现化角色接口的具体实现，好
            比各种具体的颜色。
 */
public class Client {

    public static void main(String[] args) {
        BasePen pen=new BigPen();
        BasePen pen2=new SmallPen();
        BaseColor color=new RedColor();
        BaseColor color2=new BlueColor();
        //设置颜色
        pen.setBc(color);
        //画图
        pen.draw();

        pen2.setBc(color2);
        pen2.draw();
    }
}
