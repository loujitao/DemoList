package bright.pen;

public class SmallPen extends BasePen {
    @Override
    public void draw() {
        System.out.println(bc.bepaint()+"细笔，画图！");
    }
}
