package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.DispatchDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DispatchMapper {

    DispatchDTO findById(int id);
//    void updateDispatch(DispatchDTO dispatchDTO);
    void insertDispatch(@Param("outboundId") int outboundId, @Param("vehicleId") int vehicleId, @Param("vehicleType") String vehicleType);

    //확장성: 운전기사가 approve할때 트리거로 allocation ++
    //지금은 일단 배차량이 80이하면 바로 배차 등록되는 것으로 구현
    void updateDispatchApproval(@Param("outboundId") int outboundId, @Param("vehicleId") int vehicleId, @Param("vehicleType") String vehicleType);

    void updateVehicleAllocation(@Param("outboundId") int outboundId, @Param("vehicleId") int vehicleId, @Param("vehicleType") String vehicleType);


}
