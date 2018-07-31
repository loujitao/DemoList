package com.teleinfo.filter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.utils.HttpClientUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class test {

    public static void main(String[] args) {

//        String jsonStr="{\"handle\":\"88.1000/510000.10000050200017\",\"values\":[{\"data\":{\"format\":\"string\",\"value\":\"10000050200017\"},\"index\":1,\"type\":\"URL\"}]}";
//        String  url="http://45.120.243.35:8080/hdlproxy/api";
//        String data = sendPost(url, jsonStr);
//        System.out.println("return json===="+ JSONObject.parseObject(data));


        String handle="88.1000/510000.10000051170000";
//        String  urlLast="http://45.120.243.35:8080/hdlproxy/api";
        String  urlLast="http://45.120.243.35:8080/hdlproxy/api/88.1000/510000.10000051170000";
        String data =doGET(urlLast);
//        String data = urlGet(urlLast,handle);
//        String data = urlGet(urlLast,handle);
        JSONObject js = JSONObject.parseObject(data);
        System.out.println("return json===="+ JSONObject.parseObject(data));

    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/json");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String urlGet(String url,String jsonString){
        if (url==null ||"".equals(url.trim())){
            return "";
        }
        if (jsonString==null ||"".equals(jsonString.trim())){
            return "";
        }
        String returnLine = "";
        try {
            System.out.println("**************开始http通讯**************");
            System.out.println("**************调用的接口地址为**************");
            System.out.println(url);
            System.out.println("**************请求发送的数据为**************");
            System.out.println(jsonString);
            URL my_url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) my_url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            byte[] content = jsonString.getBytes("utf-8");
            out.write(content, 0, content.length);
            out.flush();
            out.close(); // flush and close
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            //StringBuilder builder = new StringBuilder();
            String line = "";
            System.out.println("Contents of post request start");
            while ((line = reader.readLine()) != null) {
                // line = new String(line.getBytes(), "utf-8");
                returnLine += line;
            }
            System.out.println("Contents of post request ends");
            reader.close();
            connection.disconnect();
            System.out.println("**************返回的结果为**************");
            System.out.println(returnLine);
            System.out.println("**************http通讯结束**************");

            return returnLine;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String doGET(String urlAddress) { try {
        // 创建URL对象
        URL url = new URL(urlAddress);
        // 打开连接 获取连接对象
        URLConnection connection = url.openConnection();
        // 从连接对象中获取网络连接中的输入字节流对象
         InputStream inputStream = connection.getInputStream();
         // 将输入字节流包装成输入字符流对象,并进行字符编码
         InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
         // 创建一个输入缓冲区对象，将字符流对象传入
         BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 定义一个字符串变量，用来接收输入缓冲区中的每一行字符串数据
         String line;
        // 创建一个可变字符串对象，用来装载缓冲区对象的数据，使用字符串追加的方式，将响应的所有数据都保存在该对象中
         StringBuilder stringBuilder = new StringBuilder();
        // 使用循环逐行读取输入缓冲区的数据，每次循环读入一行字符串数据赋值给line字符串变量，直到读取的行为空时标识内容读取结束循环
         while ((line = bufferedReader.readLine()) != null) {
        // 将从输入缓冲区读取到的数据追加到可变字符对象中
         stringBuilder.append(line);
         }
        // 依次关闭打开的输入流
         bufferedReader.close();
         inputStreamReader.close();
         inputStream.close();
        // 将可变字符串转换成String对象返回
         return stringBuilder.toString();
         } catch (IOException e) {
         e.printStackTrace();
         }
         return null;
         }



}
