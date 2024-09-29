package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.request.OutboundApprovalRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OutboundApprovalMapper {

    //param과 값을 매핑해줘야 함?
    void insertOutboundApproval(@Param("approverId") int id, @Param("requestDTO") OutboundApprovalRequestDTO requestDTO);


}
