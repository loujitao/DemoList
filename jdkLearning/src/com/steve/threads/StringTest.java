package com.steve.threads;

public class StringTest {

    /**
     * @Author Loujitao
     * @Date 2018/6/21
     * @Time  11:10
     * @Description:
     * 提示：如果有对象参与相加，编译器没法处理，结果为新的对象
     *       字符串常量直接相加，会先经过编译器处理；
     *       且常量使用过就是一个对象，下次使用不产生新对象。
     */
    public static void main(String[] args) {
        String a="1";
        String b="";

        String str1=a+b;
        String str2=a+b;
        String str3="1"+b;
        String str4="1"+"";
        String str5="1"+"";

        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1==str4);

        System.out.println(str2==str3);
        System.out.println(str2==str4);

        System.out.println(str3==str4);

        System.out.println(str4==str5);
        System.out.println(a==str5);
/*  结果显示为：
        false
        false
        false
        false
        false
        false
        true
        true
*/
    }
}
