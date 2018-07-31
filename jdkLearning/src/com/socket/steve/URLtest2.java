package com.socket.steve;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class URLtest2 {

    /**
     * @Author Loujitao
     * @Date 2018/7/30
     * @Time  11:37
     * @Description: 这个是不是可以写爬虫
     */
    public static void main(String[] args) {
        try {
            String str="http://www.qq.com";// http://  协议头是必不可少的
            URL url=new URL(str);//创建URL对象
            URLConnection con=url.openConnection();//获得链接对象
            con.connect();//打开到URL引用资源的通信链接
            InputStream is=con.getInputStream();//获取刘对象
            InputStreamReader isr=new InputStreamReader(is,"UTF-8");//转换为字符流
            BufferedReader br=new BufferedReader(isr);//创建缓冲流对象
            String nextLine=br.readLine();
            List<String> resultList=new ArrayList<>();
            while (nextLine!=null){
                resultList.add(nextLine);
                nextLine=br.readLine();
            }
            System.out.println("集合长度："+resultList.size());
            for (String result:resultList) {
                System.out.println(result.toString());
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
