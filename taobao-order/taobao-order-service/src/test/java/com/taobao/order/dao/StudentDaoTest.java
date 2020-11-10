package com.taobao.order.dao;

import com.taobao.order.demo.Address;
import com.taobao.order.demo.Student;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Lawrence Li
 * @date 2020/10/26 2:50 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void saveStudent() {
        Student student = new Student(ObjectId.get(), "杜月笙", 19, new Address("南京东路100号", "上海", "200376"), "2020-09-10");
        studentDao.saveStudent(student);
    }

    @Test
    public void queryStudentByName() {
        List<Student> list = studentDao.queryStudentByName("james");
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void testQueryStudentByName() {
        List<Student> list = studentDao.queryStudentByName(1, 2);
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setId(new ObjectId("5f9674d180f1aa55b713c01f"));
        student.setAge(27);
        studentDao.updateStudent(student);
    }

    @Test
    public void deleteById() {
        studentDao.deleteById("5f96673887472f59355c0851");
    }
}