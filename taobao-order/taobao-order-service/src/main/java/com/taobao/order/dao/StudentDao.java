package com.taobao.order.dao;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.taobao.order.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Lawrence Li
 * @date 2020/10/26 2:31 PM
 */
@Component
public class StudentDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    public void saveStudent(Student student){
        this.mongoTemplate.save(student);
    }

    public List<Student> queryStudentByName(String name){
        Query query = Query.query(Criteria.where("name").is(name));
        List<Student> list = mongoTemplate.find(query, Student.class);
        return list;
    }

    public List<Student> queryStudentByName(Integer page, Integer rows){
        Query query = new Query().limit(rows).skip((page - 1) * rows);
        List<Student> result = mongoTemplate.find(query, Student.class);
        return result;
    }

    public UpdateResult updateStudent(Student student){
        Query query = Query.query(Criteria.where("id").is(student.getId()));
        Update update = Update.update("age", student.getAge());
        return mongoTemplate.updateFirst(query, update, Student.class);
    }

    public DeleteResult deleteById(String id){
        Query query = Query.query(Criteria.where("id").is(id));
        DeleteResult remove = mongoTemplate.remove(query, Student.class);
        return remove;
    }



}
