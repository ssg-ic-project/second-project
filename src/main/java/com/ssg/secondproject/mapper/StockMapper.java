package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.request.StockLogRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper {
    void insertOutboundLog(StockLogRequestDTO stockLogRequestDTO);
}
