package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.request.StockLogRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockLogMapper {

    void insertInboundLog(StockLogRequestDTO requestDTO);

    void insertOutboundLog(StockLogRequestDTO requestDTO);

}
