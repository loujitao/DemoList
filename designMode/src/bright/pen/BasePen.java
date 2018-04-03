package bright.pen;

import bright.color.BaseColor;

/**
 * @Author Loujitao
 * @Date 2018/3/12
 * @Time  14:03
 * @Description:抽象画笔类
 */
public abstract class BasePen {
    //保留对颜色的引用
    protected BaseColor bc;

    //每种笔都有自己的实现
    public abstract void draw();

    public void setBc(BaseColor bc) {
        this.bc = bc;
    }
}
