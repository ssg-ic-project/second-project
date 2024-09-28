package com.ssg.secondproject.mapper;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OutboundMapper {
    List<OutboundResponseDTO>findList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
    OutboundResponseDTO findById(int id);
    List<OutboundResponseDTO>findByIdLog(int id);

    List<OutboundResponseDTO>findByUserInput(@Param("warehouseName") String warehouseName, @Param("approvalStatus")String approvalStatus, @Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate);

}
