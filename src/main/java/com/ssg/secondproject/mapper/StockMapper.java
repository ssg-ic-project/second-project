package com.ssg.secondproject.mapper;
import com.ssg.secondproject.domain.Stock;
import com.ssg.secondproject.domain.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import com.ssg.secondproject.dto.request.StockLogRequestDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface StockMapper {
    List<Map<String, Object>> selectAll(Map<String, Object> paramMap);
    int count();

    Stock find(Integer id);

    void update(Map<String, Object> paramMap);

    void insertOutboundLog(StockLogRequestDTO stockLogRequestDTO);
}
