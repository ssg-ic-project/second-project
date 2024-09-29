package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.StockHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StockHistoryMapper {

    List<Map<String, Object>> selectAll(Map<String, Object> paramMap);
    int count();
}
