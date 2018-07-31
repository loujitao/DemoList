package com.socket.steve;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
/**
 * @Author Loujitao
 * @Date 2018/7/30
 * @Time  14:05
 * @Description:  下载文件
 */
public class URLtest3 {

    public static void main(String[] args) {
        try {
            String str="https://qidian.gtimg.com/qdp/img/exp-logo@1x.0.1.png";// http://  协议头是必不可少的
            URL url=new URL(str);
            URLConnection con=url.openConnection();
            con.connect();
            InputStream is=con.getInputStream();
            String filePath=url.getFile();
            int pos=filePath.lastIndexOf("/");
            String fileName=filePath.substring(pos+1);
            FileOutputStream os=new FileOutputStream("D:/"+fileName);
            byte[] bytes=new byte[1024];
            int len=is.read(bytes);
            while (len!=-1){
                os.write(bytes,0,len);
                len=is.read(bytes);
            }
            os.close();
            is.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
