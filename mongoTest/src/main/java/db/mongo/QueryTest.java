package db.mongo;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.BsonType;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Indexes.ascending;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Projections.*;

/**
 * @Author Loujitao  
 * @Date 2018/4/4
 * @Time  16:56  
 * @Description:MongoDB的3.x版本java驱动相对2.x做了全新的设计，类库和使用方法上有很大区别。例如用Document替换BasicDBObject、通过Builders类构建Bson替代直接输入$命令等
 */  
public class QueryTest {

    private  MongoDatabase database;
    private MongoCollection<Document> mc;
    private FindIterable<Document> iterable=null;

    public QueryTest(MongoDatabase database) {
        this.database=database;
    }
    public MongoCollection<Document> getMc() {
        return mc;
    }
    public void setMc(MongoCollection<Document> mc) {
        this.mc = mc;
    }

    public static void main(String[] args) {
        MongoClient mongoClient=new MongoClient("211.159.160.228",27017);
        MongoDatabase database=mongoClient.getDatabase("db");
        MongoCollection<Document> mongoCollection=database.getCollection("infoc");
        QueryTest queryTest=new QueryTest(database);
        queryTest.setMc(mongoCollection);

       // queryTest.showAll();
        queryTest.createIndexs();
       // queryTest.findAllSort2();
        queryTest.findByName("lisi");
        mongoClient.close();
    }

    public void showAll(){
        iterable= mc.find();
        printList(iterable);
    }
    public void createIndexs(){
        //创建单字段索引
        mc.createIndex(new Document("age", 1));
        //创建组合索引(同样遵循最左前缀原则)
       // mc.createIndex(new Document("username", 1).append("age",-1));
        //创建全文索引
        mc.createIndex(new Document("username", "text"));
    }
    public void findByName(String username){
        iterable = mc.find(new Document("username", username));
        printList( iterable);
    }
    public void findByNameAndAge(String username,Integer age){
        iterable = mc.find(new Document("username", username).append("age",age));
        printList(iterable);
    }
    //查询title like %good% and owner=tom
    public void findByLikeNameAndAge(String username,Integer age){
        iterable = mc.find(and(regex("username", username), eq("age", age)));
        printList(iterable);
    }
    public void findAllSortByName(){
        iterable = mc.find().sort(ascending("username"));
        printList( iterable);
    }

    public void findAllSort2(){
        iterable = mc.find().sort(ascending("username", "age"));
        printList( iterable);
    }
    public void sortByAddress(){
        iterable = mc.find().sort(descending("username"));
        printList( iterable);
    }
    //查询 username= or age>
    public void findOr(String username,int age){
        iterable = mc.find(new Document("$or", Arrays.asList(new Document("username", username), new Document("age", new Document("$gt", age)))));
        printList( iterable);
    }

    public void getNameAndAge(){
        iterable = mc.find().projection(include("username", "age"));
        printList( iterable);
    }
    //返回除title外的其他字段
    public void getExcAddress(){
        iterable = mc.find().projection(exclude("address"));
        printList( iterable);
    }
    //不返回_id字段
    public void getExcId(){
        iterable = mc.find().projection(excludeId());
        printList( iterable);
    }
    //返回title和owner字段且不返回_id字段
    public void getNameAndAgeExcId(){
        iterable = mc.find().projection(fields(include("username", "age"), excludeId()));
        printList( iterable);
    }


//    {
////内嵌文档匹配
//        iterable = mc.find(new Document("comments.author", "joe"));
//        printList( iterable);
//
////一个错误的示例, 想查询评论中包含作者是white且分值>2的, 返回结果不符合预期
//        iterable = mc.find(new Document("comments.author", "white").append("comments.score", new Document("$gt", 2)));
//        printList( iterable);
//
////上面的需求正确的写法
//        iterable = mc.find(Projections.elemMatch("comments", Filters.and(eq("author", "white"), Filters.gt("score", 2))));
//        printList(iterable);
//
////查找title以good开头的, 并且comments只保留一个元素
//        iterable = mc.find(regex("title", "^good")).projection(slice("comments", 1));
//        printList( iterable);
//
////全文索引查找
//        iterable = mc.find(text("good"));
//        printList( iterable);
//
////用Filters构建的title=good
//        iterable = mc.find(eq("title", "good"));
//        printList( iterable);
//
////$in 等同于sql的in
//        iterable = mc.find(in("owner", "joe", "john", "william"));
//        printList( iterable);
//
////$nin 等同于sql的not in
//        iterable = mc.find(nin("owner", "joe", "john", "tom"));
//        printList( iterable);
//
////查询内嵌文档
//        iterable = mc.find(in("comments.author", "joe", "tom"));
//        printList( iterable);
//
////$ne 不等于
//        iterable = mc.find(ne("words", 300));
//        printList(iterable);
//
////$and 组合条件
//        iterable = mc.find(and(eq("owner", "tom"), gt("words", 300)));
//        printList( iterable);
//
////较复杂的组合
//        iterable = mc.find(and(or(eq("words", 300), eq("words", 400)), or(eq("owner", "joe"), size("comments", 2))));
//        printList( iterable);
//
////查询第2个元素值为2的数组
//        iterable = mc.find(eq("tag.1", 2));
//        printList( iterable);
//
////查询匹配全部值的数组
//        iterable = mc.find(all("tag", Arrays.asList(1, 2, 3, 4)));
//        printList( iterable);
//
////$exists
//        iterable = mc.find(exists("tag"));
//        printList( iterable);
//
//        iterable = mc.find(type("words", BsonType.INT32));
//        printList(iterable);
//    }

    
    public void printList( FindIterable<Document> fIterable){
        fIterable.forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document);
            }
        });
    }
}
