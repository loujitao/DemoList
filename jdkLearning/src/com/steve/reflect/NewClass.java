package com.steve.reflect;

public class NewClass {

    public static void main(String[] args) throws Exception{
//        function01();
//        function02();
        function03();
    }

    /**
     * @Author Loujitao
     * @Date 2018/6/27
     * @Time  11:32
     * @Description: 第一种通过实例对象获取字节码类
     */
    public  static  void function01(){
        Person person=new Person();
        Class c=person.getClass();
        System.out.println(c);
        /**结果：
        *   无参构造函数，运行...
        *   class com.steve.reflect.Person
        */
    }

    public  static  void function02(){
        //通过静态方法获取字节码类
        Class c=Person.class;
        System.out.println(c);
        /**结果：
        *   class com.steve.reflect.Person
        */
    }

    public  static  void function03() throws Exception{
        //通过类名获取字节码类
        Class c  = Class.forName("com.steve.reflect.Person");
        System.out.println(c);
        /**结果：
        *   class com.steve.reflect.Person
        */
    }

}
