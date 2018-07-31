package com.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    private final static String url="172.17.70.215";
    private final static int port=8888;
    private static BufferedReader reader=null;
    private static  PrintWriter writer=null;

    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("接受到客户端信息：" + reader.readLine());

                writer=new PrintWriter(socket.getOutputStream(),true);
                writer.println("hello client!");
//                writer.flush();     //如果新建writer的时候没有设置true，需要手动flush,将消息推送出去
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }


}
