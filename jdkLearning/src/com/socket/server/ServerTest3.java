package com.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerTest3 {
    private String url="172.17.70.215";
    private int port=8900;
    private BufferedReader  reader;
    private BufferedReader  cliReader;
    private  PrintWriter   writer;
    private  PrintWriter   cliWriter;

    public void getServer(){
        try {
            ServerSocket server=new ServerSocket(port);
            while (true){
                System.out.println("等待客户端连接...");
                Socket socket=server.accept();
                reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientInfo(reader);

                writer=new PrintWriter(socket.getOutputStream(),true);
                writer.println("服务器消息！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getConnect(){
        try {
            Socket socket=new Socket(url,port);
            cliWriter=new PrintWriter(socket.getOutputStream(),true);
            cliWriter.println("Hello world!");

            cliReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("客户端收到："+cliReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(cliReader!=null){
                try {
                    cliReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getClientInfo(BufferedReader  reader){
        try {
            System.out.println("读取客户端信息："+reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final ServerTest3 st=new ServerTest3();
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
