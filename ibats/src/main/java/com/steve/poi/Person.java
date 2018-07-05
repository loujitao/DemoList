package com.steve.poi;

public class Person {

    private  String name;
    private  long age;
    private  boolean sex;
    private String phone;
    private  int grade;

    public Person() {
    }

    public Person(String name, long age, boolean sex, String phone, int grade) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", grade=" + grade +
                '}';
    }
}
