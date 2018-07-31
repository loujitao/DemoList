package com.socket.steve;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpGet {

    public static void main(String[] args){
        try {
            InetAddress host=InetAddress.getLocalHost();
            System.out.println("获得本机的InetAddress："+host);
            System.out.println("获得本机的IP地址："+host.getHostAddress());
            System.out.println("获得本机的主机名称:"+host.getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
