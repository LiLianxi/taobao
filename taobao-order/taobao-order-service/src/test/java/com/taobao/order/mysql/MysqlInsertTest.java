package com.taobao.order.mysql;

import com.taobao.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lawrence Li
 * @date 2020/11/5 2:20 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlInsertTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test01(){
        orderService.testBatchInsert();
    }

    @Test
    public void test02(){
        orderService.testTransaction2();
    }



}
