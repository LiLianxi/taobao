package com.taobao.order.common.utils;

import com.taobao.order.common.enums.ExceptionEnum;
import com.taobao.order.common.exceptions.HotelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:53 PM
 */
public class BeanHelper {


    private static final Logger logger = LoggerFactory.getLogger(BeanHelper.class);

    public static <T> T copyProperties(Object source, Class<T> target){
        try {
            T t = target.newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception e) {
            logger.error("【Data Convert】data convert exception，target object{}constructor method cause exception", target.getName(), e);
            throw new HotelException(ExceptionEnum.DATA_TRANSFER_ERROR);
        }
    }

    public static <T> List<T> copyWithCollection(List<?> sourceList, Class<T> target){
        try {
            return sourceList.stream().map(s -> copyProperties(s, target)).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("【Data Convert】data convert exception，target object{}constructor method cause exception", target.getName(), e);
            throw new HotelException(ExceptionEnum.DATA_TRANSFER_ERROR);
        }
    }

    public static <T> Set<T> copyWithCollection(Set<?> sourceList, Class<T> target){
        try {
            return sourceList.stream().map(s -> copyProperties(s, target)).collect(Collectors.toSet());
        } catch (Exception e) {
            logger.error("【Data Convert】data convert exception，target object{}constructor method cause exception", target.getName(), e);
            throw new HotelException(ExceptionEnum.DATA_TRANSFER_ERROR);
        }
    }



}
