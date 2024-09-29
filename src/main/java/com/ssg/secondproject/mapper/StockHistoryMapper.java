package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.StockHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockHistoryMapper {

    List<StockHistory> selectAll();
}
