package com.ssg.secondproject.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StockLogMapper {

    List<Map<String, Object>> selectAll(Map<String, Object> paramMap);
    int count();
}
