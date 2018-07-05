package com.steve.reflect;

public class Person  {

    public static final long serialVersionUID=1l;
    public  String name;
    private  int age;

    public Person() {
        System.out.println("无参构造函数，运行...");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造函数，运行...");
        System.out.println("name:"+this.name+",age:"+this.age);

    }

    public void method01(){
        System.out.println("共有无参函数，运行...");
    }
    private void method02(){
        System.out.println("私有无参函数，运行...");
    }
    public void method03(String name,int age){
        System.out.println("公有带参函数，name:"+name+"; age:"+age);
    }
    private void method04(String name,int age){
        System.out.println("私有带参函数，name:"+name+"; age:"+age);
    }

}
