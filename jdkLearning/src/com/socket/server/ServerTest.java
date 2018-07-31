package com.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerTest {
    private String url="172.17.70.215";
    private int port=8900;

    public void getServer(){
        try {
            ServerSocket server=new ServerSocket(port);
            server.setSoTimeout(10000);//设置10s连接超时时间
            System.out.println("服务套接字建立完成！");
            while (true){
                System.out.println("等待客户端连接...");
                Socket socket=server.accept();
            }
        } catch (SocketTimeoutException se){
            System.out.println("连接超时！");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getConnect(){
        try {
            System.out.println("尝试连接服务器...");
            Socket socket=new Socket(url,port);
            System.out.println("连接服务器成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final ServerTest st=new ServerTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                st.getServer();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                st.getConnect();
            }
        }).start();
    }



}
