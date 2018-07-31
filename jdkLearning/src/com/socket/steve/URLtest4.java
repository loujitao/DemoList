package com.socket.steve;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author Loujitao
 * @Date 2018/7/30
 * @Time  14:05
 * @Description: 多线程下载
 */
public class URLtest4 {

    public static void main(String[] args) {
        try {
            String str="https://qidian.gtimg.com/qdp/img/exp-logo@1x.0.1.png";// http://  协议头是必不可少的
            URL url=new URL(str);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            long fileLength=-1;
            int stateFlagCode=con.getResponseCode();
            if(stateFlagCode==200){
                fileLength=con.getContentLength();
                con.disconnect();
            }
            if(fileLength>0){
                long byteCounts=fileLength/5+1;
                String filename=url.getFile();
                File file=new File("D://"+filename.substring(filename.lastIndexOf("/")));
                int i=0;
                while (i<5){
                    long startPosition=byteCounts*i;
                    long endPosition=byteCounts*(i+1);
                    if(i==4){
                        DownLoadThread t1=new DownLoadThread(str,file,startPosition,0);
                        new Thread(t1).start();
                    }else {
                        DownLoadThread t1=new DownLoadThread(str,file,startPosition,endPosition);
                        new Thread(t1).start();
                    }
                    i++;
                }
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    static class DownLoadThread implements Runnable{
        private String sUrl="";     //网络资源地址
        private File desFile;       //需要写入的文件对象
        private long startPos;      //写入的开始位置
        private long endPos;        //写入的结束位置
        public DownLoadThread(String sUrl, File desFile, long startPos, long endPos) {
            this.sUrl = sUrl;
            this.desFile = desFile;
            this.startPos = startPos;
            this.endPos = endPos;
        }
        @Override
        public void run() {
            try {
                URL downURL=new URL(sUrl);
                HttpURLConnection con= (HttpURLConnection) downURL.openConnection();
                RandomAccessFile out=new RandomAccessFile(desFile,"rw");
                out.seek(startPos);
                InputStream in=con.getInputStream();
                BufferedInputStream bin=new BufferedInputStream(in);
                byte[] bytes=new byte[2048];
                int len=-1;
                len=bin.read(bytes);
                while (len!=-1){
                    out.write(bytes,0,len);
                    len=bin.read(bytes);
                }
                System.out.println("写入完成！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
