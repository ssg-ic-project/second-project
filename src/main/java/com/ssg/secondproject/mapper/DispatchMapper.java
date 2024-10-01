package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.DispatchDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

@Mapper
public interface DispatchMapper {

    DispatchDTO findById(int id);
//    void updateDispatch(DispatchDTO dispatchDTO);
    void insertDispatch(@Param("outboundId") int outboundId, @Param("vehicleId") int vehicleId, @Param("remark") Long remark, @Param("createdAt")LocalDateTime createdAt);


    //확장성: 운전기사가 approve할때 트리거로 allocation ++
    //지금은 일단 배차량이 80이하면 바로 배차 등록되는 것으로 구현
    void updateDispatchApproval(@Param("approvalId") int approvalId, @Param("outboundId") int outboundId, @Param("status") String status, @Param("createdAt") LocalDateTime createdAt);

    void updateVehicleAllocation(@Param("outboundId") int outboundId, @Param("vehicleId") int vehicleId, @Param("vehicleType") String vehicleType);


}
