package com.steve.clone;

import com.steve.reflect.Person;

import java.io.Serializable;

//嵌套类分为静态嵌套类和内部类  内部类的其余两种形式：局部类 匿名内部类
// 外部类   内部类使“多重继承”的解决方案变得更加完整。
/* 1.静态内部类可以有静态成员(方法，属性)，而非静态内部类则不能有静态成员(方法，属性)。
 * 2.静态内部类只能够访问外部类的静态成员,而非静态内部类则可以访问外部类的所有成员(方法，属性)。
 */
public class CloneTest01 {
    private String a;
    private  static String b;
    private static void outPrint(){}
    private  void outPrint2(){}

    public static void main(String[] args) {
// 3、静态类和方法只属于类本身，并不属于该类的对象，更不属于其他外部类的对象。
        //4.1、非静态内部类的实例化: 外部类实例.new  内部类
        CloneTest01 ct=new CloneTest01();
        Person p=ct.new Person();
       //4.2、静态内部类可以直接实例化  它属于外部类类的，不是外部类实例的
        Student s=new Student();
        class LocalClass{
            private String a;
            public void print(){
                //5、访问方法的局部变量时，变量要加上final修饰
                System.out.println("局部内部类");
            }
        }
        new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };
    }
      //非静态内部类
      class Person implements Cloneable,Serializable{
// 非静态内部类则不能有静态成员(方法，属性)。
       // private static String name;  //会报错
        private int age;
        public void printA(){
//            可以访问外部类的所有成员(方法，属性)
            System.out.println(a+b);
            outPrint();
            outPrint2();
        }
//        public static void printb(){}   //会报错
    }
    //静态内部类
   static class Student implements Runnable{
 // 静态内部类可以有静态成员(方法，属性)
       private static String name;
       private int age;
       public void printA(){}
       public static void printb(){
           //只能够访问外部类的静态成员(方法，属性)
           System.out.println(b);
           outPrint();
       }
        @Override
        public void run() {
            System.out.println(this.age);
        }
    }

}
