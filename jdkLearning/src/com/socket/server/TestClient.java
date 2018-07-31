package com.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClient {
    private final static String url="172.17.70.215";
    private final static int port=8888;
    private static BufferedReader reader=null;
    private static PrintWriter writer=null;

    public static void main(String[] args) {
        try {
            Socket socket=new Socket(url,port);
            writer=new PrintWriter(socket.getOutputStream(),true);
            writer.println("this is client!");

            reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("客户端接受到信息："+reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
