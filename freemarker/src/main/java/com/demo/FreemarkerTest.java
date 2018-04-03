package com.demo;

import com.domain.Group;
import com.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerTest {

    public static void main(String[] args) {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("username", "王风");//在ftl中要赋值的变量
        root.put("user", new User(1,"name1",11,new Group("组1")));
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"name1",11));
        users.add(new User(2,"name2",15));
        users.add(new User(3,"name3",20));
        users.add(new User(4,"name4",30));
        root.put("users", users);

        FreeMarKerDemo util = new FreeMarKerDemo();
       // util.fprint("001.jsp", root, "0001.jsp");

        util.fprint("01.ftl", root, "01.html");
        util.fprint("02.ftl", root, "02.html");
        util.fprint("03.ftl", root, "03.html");
        util.fprint("04.ftl", root, "04.html");
        util.fprint("05.ftl", root, "05.html");
//        util.fprint("06.ftl", root, "06.html");
    }
}
