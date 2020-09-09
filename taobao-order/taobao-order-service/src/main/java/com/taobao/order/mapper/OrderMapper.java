package com.taobao.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lawrence Li
 * @date 2020/8/7 2:03 PM
 */
@Mapper
public interface OrderMapper {

    /**
     * query order by id
     *
     * @param id
     * @return
     */
    int queryOrderById(@Param("id") Long id);
}
