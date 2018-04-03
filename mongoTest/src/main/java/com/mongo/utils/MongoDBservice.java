package com.mongo.utils;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoDBservice {
    private String dbName;
    private String collName;
    private DB db;

    //有参构造方法，指定数据库名与集合名
    public MongoDBservice(String dbName, String collName) {
        this.dbName = dbName;
        this.collName = collName;
        try {
            db = getDb();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    //无参构造方法，返回配置文件配置的数据库对象引用，如果配置文件中没有设置则返回默认数据库对象引用
    public MongoDBservice() {
        getDb();
    }
    /*
     * 获取数据库对象，3种情况（优先级从高到低）：
     *1、构造方法指定2、配置文件指定3、默认数据库
     *（情况2、3在MongoDButil中设置）
     */
    public DB getDb() {
        if (this.db == null) {
            if (this.dbName == null) {
                this.db = MongoDBUtil.getDB();
            } else {
                this.db = MongoDBUtil.getDBByName(this.dbName);
            }
        }
        return this.db;
    }

    /*
     * 获取集合对象，3种情况（优先级从高到低）：
     *1、构造方法指定2、配置文件指定3、默认数据库
     *（情况2、3在MongoDButil中设置）
     */
    public DBCollection getCollection() {
        if(this.collName != null){
            return db.getCollection(this.collName);
        }
        else {
            return MongoDBUtil.getDBCollection();
        }
    }

    public DBObject map2Obj(Map<String, Object> map) {
        DBObject obj = new BasicDBObject();
        if (map.containsKey("class") && map.get("class") instanceof Class)
            map.remove("class");
        obj.putAll(map);
        return obj;
    }
    //插入数据
    public void insert(DBObject obj) {
        getCollection().insert(obj);
    }
    //插入多条数据
    public void insertBatch(List<DBObject> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        List<DBObject> listDB = new ArrayList<DBObject>();
        for (int i = 0; i < list.size(); i++) {
            listDB.add(list.get(i));
        }
        getCollection().insert(listDB);
    }
    //删除数据
    public void delete(DBObject obj) {
        getCollection().remove(obj);
    }
    //删除多条数据
    public void deleteBatch(List<DBObject> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            getCollection().remove(list.get(i));
        }
    }
    //获取集合中的数据数量
    public long getCollectionCount() {
        return getCollection().getCount();
    }
    //查找符合条件的数据数量
    public long getCount(DBObject obj) {
        if (obj != null)
            return getCollection().getCount(obj);
        return getCollectionCount();
    }
    //查找符合条件的数据
    public List<DBObject> find(DBObject obj) {
        DBCursor cur = getCollection().find(obj);
        return DBCursor2list(cur);
    }

    //查找符合条件的数据并排序
    public List<DBObject> find(DBObject query, DBObject sort) {
        DBCursor cur;
        if (query != null) {
            cur = getCollection().find(query);
        } else {
            cur = getCollection().find();
        }
        if (sort != null) {
            cur.sort(sort);
        }
        return DBCursor2list(cur);
    }

    //查找符合条件的数据并排序，规定数据个数
    public List<DBObject> find(DBObject query, DBObject sort, int start,
                               int limit) {
        DBCursor cur;
        if (query != null) {
            cur = getCollection().find(query);
        } else {
            cur = getCollection().find();
        }
        if (sort != null) {
            cur.sort(sort);
        }
        if (start == 0) {
            cur.batchSize(limit);
        } else {
            cur.skip(start).limit(limit);
        }
        return DBCursor2list(cur);
    }

    //将DBCursor转化为list<dbobject>
    private List<DBObject> DBCursor2list(DBCursor cur) {
        List<DBObject> list = new ArrayList<DBObject>();
        if (cur != null) {
            list = cur.toArray();
        }
        return list;
    }

    //更新数据
    public void update(DBObject setFields, DBObject whereFields) {
        getCollection().updateMulti(whereFields, setFields);
    }
    //查询集合中所有数据
    public List<DBObject> findAll() {
        DBCursor cur = getCollection().find();
        List<DBObject> list = new ArrayList<DBObject>();
        if (cur != null) {
            list = cur.toArray();
        }
        return list;
    }
    //由ID获取数据
    public DBObject getById(String id) {
        DBObject obj = new BasicDBObject();
        obj.put("_id", new ObjectId(id));
        DBObject result = getCollection().findOne(obj);
        return result;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
        this.db = MongoDBUtil.getDBByName(this.dbName);
    }

    public String getCollName() {
        return collName;
    }

    public void setCollName(String collName) {
        this.collName = collName;
    }

    public void printListDBObj(List<DBObject> list) {
        for(DBObject dbObject: list){
            System.out.println(dbObject);
        }
    }
}

