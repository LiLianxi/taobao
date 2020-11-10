package com.taobao.order.mapper;

import com.taobao.order.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lawrence Li
 * @date 2020/11/5 4:27 PM
 */
@Mapper
public interface UserMapper {


    /**
     *
     * @param user
     */
    void saveUser(UserDO user);
}
