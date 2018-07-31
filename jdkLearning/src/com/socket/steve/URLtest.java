package com.socket.steve;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLtest {

    public static void main(String[] args) {
        try {
            String str="http://www.baidu.com";// http://  协议头是必不可少的
            URL url=new URL(str);
            URLConnection con=url.openConnection();
            con.connect();
            System.out.println("获取网络资源大小"+con.getContentLength()+"B");
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
