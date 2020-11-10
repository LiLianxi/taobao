package com.taobao.order.mapper;

import com.taobao.order.entity.DisneyHotelOrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lawrence Li
 * @date 2020/11/5 2:22 PM
 */
@Mapper
public interface DisneyHotelOrderMapper {


    /**
     *
     * @param orderList
     */
    void insertBatchOrder( List<DisneyHotelOrderDO> orderList);
}
