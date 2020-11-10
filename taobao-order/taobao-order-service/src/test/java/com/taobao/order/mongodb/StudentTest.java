package com.taobao.order.mongodb;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.taobao.order.demo.Address;
import com.taobao.order.demo.Student;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lawrence Li
 * @date 2020/10/26 11:43 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    private MongoCollection<Student> collection;

    private MongoClient mongoClient;

    private MongoDatabase mongoDatabase;

    @Before
    public void init(){

        //定义对象的解码注册器
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        //建立连接
        mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        //选择数据库并且注册解码器
        mongoDatabase = mongoClient.getDatabase("disney").withCodecRegistry(codecRegistry);
        //选择表
        collection = mongoDatabase.getCollection("student", Student.class);

    }


    @After
    public void after(){
        mongoClient.close();
        System.out.println("close the client");
    }

    /*@Test
    public void testInsert(){
        Student student = new Student(ObjectId.get(), "James", 35, new Address("cow street", "Cli", "200137"));
        this.collection.insertOne(student);
    }

    @Test
    public void testInsertMany(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(ObjectId.get(), "Rose", 33, new Address("Rose street", "Chi", "200135")));
        students.add(new Student(ObjectId.get(), "Shaquille", 45, new Address("Oneal street", "Spu", "200136")));
        students.add(new Student(ObjectId.get(), "Jordan", 54, new Address("jordan street", "Chi", "200110")));
        this.collection.insertMany(students);
    }*/

    @Test
    public void testQuery(){
        FindIterable<Student> students = this.collection.find(Filters.eq("name", "Jordan"));
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testUpdate(){
        UpdateResult updateResult = collection.updateOne(Filters.eq("name", "Jordan"), Updates.set("age", 17));
        System.out.println(updateResult);
    }

    @Test
    public void testDelete(){
        DeleteResult zip = collection.deleteOne(Filters.eq("name", "Jordan"));
        System.out.println(zip);
    }


}
