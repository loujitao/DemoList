package com.mongo.test;

import com.mongodb.Cursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MongoTest {

    public static void main(String[] args) {
      //  1、无密码访问     连接"localhost:27017"可以直接使用无参构造new MongoClient();
    MongoClient mongoClient = new MongoClient( "211.159.160.228" , 27017 );

//        //2、有密码访问   连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
// // ServerAddress()两个参数分别为 服务器地址 和 端口
//        ServerAddress serverAddress = new ServerAddress("localhost",27017);
//        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
//        addrs.add(serverAddress);
////MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
//        MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
//        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
//        credentials.add(credential);
////通过连接认证获取MongoDB连接
//        MongoClient mongoClient = new MongoClient(addrs,credentials);

        //获取操作数据库/不存在会创建
        MongoDatabase db = mongoClient.getDatabase("person");
        //获得指定集合
        MongoCollection<Document> users = db.getCollection("steve");

        //A、遍历所有数据
//        FindIterable<Document> documents = users.find();
//        for (Document document : documents) {
//            System.out.println(document);
//        }

        //B、查找所有age = 16的document
//        Document query1 = new Document("age", 16);
//        FindIterable<Document> documents1= users.find(query1);
//        for (Document d : documents1) {
//            System.out.println(d.toJson());
//        }

        //C、使用运算符“$lt”,"$gt","$lte","$gte"   age < 15
//        Document query2 = new Document("age", new Document("$lt", 15));
//        FindIterable<Document> documents2 = users.find(query2);
//        for (Document d : documents2) {
//            System.out.println(d.toJson());
//        }

       // Document query3 = new Document("age", new Document("$lt", 25)).append("name", "csc");
       // FindIterable<Document> documents = users.find(query3);
       //D、and连接多个条件。也可以：
//        Document query4 = new Document("name", "stevetao");
//        query4.put("age", new Document("$lt", 15));
//        FindIterable<Document> documents3 = users.find(query4);
//        for (Document d : documents3) {
//            System.out.println(d.toJson());
//        }

        //E、or连接多个条件 name = linna || name == jim
//        Document query5 = new Document("$or",
//                Arrays.asList(new Document("name", "linna"),
//                              new Document("name", "jim"))
//            );
//        FindIterable<Document> documents4 = users.find(query5);
//        for (Document d : documents4) {
//            System.out.println(d.toJson());
//        }

        //F、between...and...      11<=age<16
        Document query6 = new Document("age", new Document("$lt", 16).append("$gte", 11));
        FindIterable<Document> documents5 = users.find(query6);
        for (Document d : documents5) {
            System.out.println(d.toJson());
            //System.out.println(d); map<string,object>
        }


    }

}
