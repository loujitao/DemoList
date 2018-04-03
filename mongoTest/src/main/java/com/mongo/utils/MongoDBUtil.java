package com.mongo.utils;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class MongoDBUtil {
    // 定义默认配置，1、IP地址 2、端口号 3、用户名 4、密码 5、配置文件位置名 6、数据库名
    private static final String MONGODB_ADDRESS = "211.159.160.228";
    private static final int MONGODB_PORT = 27017;
    private static final String MONGODB_USERNAME = "root";
    private static final String MONGODB_PASSWORD = "";
    private static final String MONGODB_RESOURCE_FILE = "mongodb.cfg.properties";
    private static final String MONGODB_DBNAME = "test";
    private static final String MONGODB_COLLECTIONNAME = "test";
    // 定义静态变量，1、Mongo对象（代表数据库连接）2、DB对象（代表数据库）3、集合名4、数据库相关配置映射集合5、已获取的数据库连接
    private static Mongo mongo;
    private static DB db;
    private static DBCollection collection;
    private static Map<String, String> cfgMap = new HashMap<String, String>();
    private static Hashtable<String, DB> mongoDBs = new Hashtable<String, DB>();

    /**
     * 初始化Mongo的数据库
     */
    static {
        init();
    }

    /**
     * 获取配置文件中配置的DB对象
     */
    public static DB getDB() {
        return db;
    }

    /**
     * 获取配置文件中配置的DBCollection对象
     */
    public static DBCollection getDBCollection() {
        return collection;
    }

    /**
     * 根据数据库名称,得到数据库 如果不存在,则创建一个该名称的数据库,并设置用户名和密码为配置文件中的参数值
     *
     * @param dbName
     * @return DB
     */
    @SuppressWarnings("deprecation")
    public static DB getDBByName(String dbName) {
        DB db = mongo.getDB(dbName);
        if (!mongoDBs.contains(db)) {
            System.out.println("add");
            db.addUser(cfgMap.get("mongo.db.username"),
                    cfgMap.get("mongo.db.password").toCharArray());
            mongoDBs.put(dbName, db);
        }
        return db;
    }

    // ————————————————————————————————————初始化过程————————————————————————————————————
    /**
     * 获取配置文件mongedb.cfg.properties的文件对象
     */
    public static File getConfigFile() {
        String path = MongoDBUtil.class.getResource("/").getPath();
        String fileName = path + MONGODB_RESOURCE_FILE;
        System.out.println(fileName);
        File file = new File(fileName);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /**
     * 通过mongedb.cfg.properties配置文件初始化配置映射集合，如果没有编写配置文件，则加载程序指定的默认配置
     */
    @SuppressWarnings("unchecked")
    private static void initCfgMap() {
        File file = getConfigFile();
        if (file != null) {
            Properties p = new Properties();
            try {
                p.load(new FileInputStream(file));
                for (Enumeration enu = p.propertyNames(); enu.hasMoreElements();) {
                    String key = (String) enu.nextElement();
                    String value = (String) p.getProperty(key);
                    cfgMap.put(key, value);
                }
            } catch (IOException e) {
                System.out.println("加载Mongo配置文件失败!");
                e.printStackTrace();
            }
        } else { // 如果没有编写配置文件，则加载默认配置
            cfgMap.put("mongo.db.address", MONGODB_ADDRESS);
            cfgMap.put("mongo.db.port", String.valueOf(MONGODB_PORT));
            cfgMap.put("mongo.db.username", MONGODB_USERNAME);
            cfgMap.put("mongo.db.password", MONGODB_PASSWORD);
            cfgMap.put("mongo.db.dbname", MONGODB_DBNAME);
            cfgMap.put("mongo.db.collectionname", MONGODB_COLLECTIONNAME);
        }
    }

    /**
     * 初始化Mongo的数据库（将db指向相应对象引用，将collection指向相应对象引用，通过mongoDBs记录现有数据库对象）
     */
    @SuppressWarnings("deprecation")
    private static void init() {
        initCfgMap();
        try {
            String address = cfgMap.get("mongo.db.address");
            int port = Integer.parseInt(cfgMap.get("mongo.db.port").toString());
            String dbName = cfgMap.get("mongo.db.dbname");
            String username = cfgMap.get("mongo.db.username");
            String password = cfgMap.get("mongo.db.password");
            String collectionName = cfgMap.get("mongo.db.collectionname");
            mongo = new Mongo(address, port);
            if (dbName != null && !"".equals(dbName)) {
                db = mongo.getDB(dbName);
                if (username != null && !"".equals(username)) {
                    db.addUser(username, password.toCharArray());
                    if (collectionName != null && !"".equals(collectionName)) {
                        collection = db.getCollection(collectionName);
                    }
                }
                mongoDBs.put(dbName, db);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
