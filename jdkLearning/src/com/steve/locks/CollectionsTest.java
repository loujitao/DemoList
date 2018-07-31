package com.steve.locks;

import java.util.*;

public class CollectionsTest {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        //这样safeList就是线程安全的list了
        List<String> safeList= Collections.synchronizedList(list);

        Map<String,Object> map=new HashMap<>();
        Map<String,Object> safeMap=Collections.synchronizedMap(map);

        //其实HashSet的源码是利用HashMap的key这部分实现的
        Set<String> set=new HashSet<>();
        Set<String> safeSet=Collections.synchronizedSet(set);
    }

}
