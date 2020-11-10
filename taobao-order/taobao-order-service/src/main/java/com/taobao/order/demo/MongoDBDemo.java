package com.taobao.order.demo;


import com.mongodb.client.*;
import org.bson.Document;

import java.util.function.Consumer;

/**
 * @author Lawrence Li
 * @date 2020/10/23 2:13 PM
 */
public class MongoDBDemo {
    public static void main(String[] args) {

//        ConnectionString connString = new ConnectionString("mongodb://127.0.0.1:27017");
//
//        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connString).retryWrites(true).build();

        // 建立连接
        MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        //选择数据库
        MongoDatabase disney = mongoClient.getDatabase("disney");
        //选择数据表
        MongoCollection<Document> user = disney.getCollection("user");

        //查询数据
        FindIterable<Document> limit = user.find().limit(10);
        limit.forEach((Consumer<? super Document>) document -> {
            System.out.println(document);
        });


        mongoClient.close();


    }
}
