package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.request.InboundApprovalRequestDTO;
import com.ssg.secondproject.dto.request.StockLogRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper {

    void insertInboundLog(StockLogRequestDTO requestDTO);

    void insertOutboundLog(StockLogRequestDTO requestDTO);

}
