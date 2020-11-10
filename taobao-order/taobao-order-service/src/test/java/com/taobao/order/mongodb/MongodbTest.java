package com.taobao.order.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;

/**
 * @author Lawrence Li
 * @date 2020/10/26 10:47 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbTest {

    private MongoCollection<Document> collection;

    private MongoClient mongoClient;

    private MongoDatabase mongoDatabase;

    @Before
    public void init(){

        mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        mongoDatabase = mongoClient.getDatabase("disney");
        collection = mongoDatabase.getCollection("user");

    }


    @After
    public void after(){
        mongoClient.close();
    }


    @Test
    public void testQuery(){

        // 查询age<=15并且id>=100的用户信息，并且按照id倒序排序，只返回id，age字段，不返回_id字段

        this.collection.find(
               /* and(
                        lte("age",15),
                        gte("id",100)
                )*/
                Filters.and(
                        Filters.lte("age",15),
                        Filters.gte("id",100)
                )
        )
                .sort(Sorts.descending("id"))
                .projection(
                        Projections.fields(
                                Projections.include("id","age"),
                                Projections.excludeId()
                        )
                )
                .forEach((Consumer<Document>) document -> {
                    System.out.println(document.toJson());
                });
    }

    @Test
    public void testInsert(){
        Document document = new Document().append("id", 10086).append("name", "james").append("age", 35);
        collection.insertOne(document);
        System.out.println("insert success");
    }

    @Test
    public void testUpdate(){
        UpdateResult updateResult = collection.updateOne(eq("id", 10086), Updates.set("age", 65));
        System.out.println(updateResult);
    }

    @Test
    public void testDelete(){
        DeleteResult deleteResult = collection.deleteOne(eq("id",10086));
        System.out.println(deleteResult);
    }





}
