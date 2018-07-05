package com.steve.reflect;

import java.lang.reflect.Field;

public class GetFeilds {


    public static void main(String[] args) throws Exception {
        Class c  = Class.forName("com.steve.reflect.Person");
//        function01(c);
//        function02(c);
        function03(c);
    }
    /**
     * 获取单个字段
     */
    public static void  function01(Class c) throws Exception{
        //它反映此 Class 对象所表示的类或接口的指定   公共  成员字段。
        Field field=c.getField("name");
        //反映此 Class 对象所表示的类或接口的指定已声明字段。   可以获取私有的属性
        Field f=c.getDeclaredField("age");

        System.out.println("name:     "+field );
        System.out.println("age:      "+f);
       /* 结果：
          name:     public java.lang.String com.steve.reflect.Person.name
          age:      private int com.steve.reflect.Person.age
        */
    }
    /*
     * 获取字段数组 只能获取共有的字段
     * */
    public  static  void function02(Class c) throws Exception{

        Field[] fields=c.getFields();
        for (Field f:fields ) {
            System.out.println(f);
        }
       /**结果：
        *    public static final long com.steve.reflect.Person.serialVersionUID
        *    public java.lang.String com.steve.reflect.Person.name
        */
    }
    /*
     * 获取字段数组 所有的
     * */
    public static void function03(Class c)throws Exception{
        Field[] fields=c.getDeclaredFields();
        for (Field f:fields ) {
            System.out.println(f);
        }
        /**结果：
         *  public static final long com.steve.reflect.Person.serialVersionUID
            public java.lang.String com.steve.reflect.Person.name
            private int com.steve.reflect.Person.age
         * */
    }

}
