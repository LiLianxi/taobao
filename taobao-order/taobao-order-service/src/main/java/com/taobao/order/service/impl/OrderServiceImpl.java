package com.taobao.order.service.impl;

import com.taobao.order.entity.DisneyHotelOrderDO;
import com.taobao.order.entity.UserDO;
import com.taobao.order.mapper.DisneyHotelOrderMapper;
import com.taobao.order.mapper.UserMapper;
import com.taobao.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lawrence Li
 * @date 2020/8/7 2:02 PM
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DisneyHotelOrderMapper disneyHotelOrderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void testBatchInsert() {
        DisneyHotelOrderDO dh1 = new DisneyHotelOrderDO();
        dh1.setObjectId("test-003");
        DisneyHotelOrderDO dh2 = new DisneyHotelOrderDO();
        dh2.setObjectId("test-004");

        List<DisneyHotelOrderDO> list = new ArrayList<>();

        list.add(dh1);
        list.add(dh2);

        disneyHotelOrderMapper.insertBatchOrder(list);
        for (DisneyHotelOrderDO item : list) {
            System.out.println(item.getId());
        }
    }

    //@Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void testTransaction() {

        DisneyHotelOrderDO dh1 = new DisneyHotelOrderDO();
        dh1.setObjectId("test-011");
        DisneyHotelOrderDO dh2 = new DisneyHotelOrderDO();
        dh2.setObjectId("test-012");
        List<DisneyHotelOrderDO> list = new ArrayList<>();
        list.add(dh1);
        list.add(dh2);

        disneyHotelOrderMapper.insertBatchOrder(list);
        for (DisneyHotelOrderDO item : list) {
            System.out.println(item.getId());
        }

        // user
        UserDO user = new UserDO();
        user.setUsername("test-003");
        user.setPassword("pass-003");
        user.setPhone("phone-003");

        userMapper.saveUser(user);

    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void testTransaction2() {
        System.out.println("hello");
        testTransaction();
        System.out.println("world");
    }
}
