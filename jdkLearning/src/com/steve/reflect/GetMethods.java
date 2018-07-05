package com.steve.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GetMethods {

    public static void main(String[] args) throws Exception{
        Class c  = Class.forName("com.steve.reflect.Person");
//        function01(c);
//        function02(c);
        function03(c);
    }
    //获取构造函数
    public  static void function01(Class c) throws Exception{
        Object obj=c.newInstance();
        System.out.println(obj);

        Constructor ct=c.getConstructor(String.class,int.class);
        Object o= ct.newInstance("steve",18);
        System.out.println(o);
     /*结果：
        无参构造函数，运行...
        com.steve.reflect.Person@1540e19d
        有参构造函数，运行...
        name:steve,age:18
        com.steve.reflect.Person@677327b6
        */
    }
    //获取方法
    public  static void function02(Class c)throws Exception{
        Object obj=c.newInstance();
        Method m=c.getMethod("method01",null);
        m.invoke(obj);

        Method m2=c.getDeclaredMethod("method02",null);
        //将反射的对象标记为在使用时取消默认 Java 语言访问控制检查的能力
        m2.setAccessible(true);
        //对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。
        m2.invoke(obj);

        Method m3=c.getMethod("method03",String.class,int.class);
        m3.invoke(obj,"steve",26);

        Method m4=c.getDeclaredMethod("method04",String.class,int.class);
        m4.setAccessible(true);
        m4.invoke(obj,"steve",26);
    }
    //获取方法数组
    public  static void function03(Class c)throws Exception{
        //获取共有方法
        Method[] m1=c.getMethods();
        for (Method m:m1) {
            System.out.println(m);
        }
        System.out.println("----------手动分割线-------------------");
        Method[] m2=c.getDeclaredMethods();
        for (Method mt:m2 ) {
            System.out.println(mt);
        }
    }


}
