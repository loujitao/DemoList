package com.socket.steve;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DownLoadAfterOffline {
    private String urlAddress="";

    public void downLoad(long startPosition,long endPosition){
        try {
            URL url=new URL(urlAddress);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent","NetFox");
            String rangeProperty="bytes="+startPosition+"-";
            if(endPosition>0){
                rangeProperty+=endPosition;
            }
            con.setRequestProperty("RANGE",rangeProperty);
            con.connect();
            InputStream in=con.getInputStream();
            String file=url.getFile();
            String name=file.substring(file.lastIndexOf("/")+1);
            FileOutputStream out=new FileOutputStream("D:/"+name,true);
            byte[] buff=new byte[2048];
            int len=0;
            len=in.read(buff);
            while (len!=-1){
                out.write(buff,0,len);
                len=in.read(buff);
            }
            out.close();
            in.close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long startPos=0;
        long endPos=0;
        System.out.println("断点续传开始位置：");  //  0
         startPos=new Scanner(System.in).nextInt();
        System.out.println("断点续传结束位置："); //    5000
        endPos=new Scanner(System.in).nextInt();

        DownLoadAfterOffline d=new DownLoadAfterOffline();
        d.urlAddress="https://qidian.gtimg.com/qdp/img/exp-logo@1x.0.1.png";
        d.downLoad(startPos,endPos);
    }


}

