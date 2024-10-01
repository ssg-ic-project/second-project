package com.ssg.secondproject.mapper;
import com.ssg.secondproject.dto.request.OutboundApprovalRequestDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.OutboundDetailResponseDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OutboundMapper {
    List<OutboundResponseDTO>findList(PageRequestDTO pageRequestDTO);
    List<OutboundDetailResponseDTO>findByUserInput(@Param("warehouseName") String warehouseName, @Param("approvalStatus")String approvalStatus, @Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate);

    int getCount(PageRequestDTO pageRequestDTO);
    OutboundDetailResponseDTO findById(int id);
    List<ApprovalResponseDTO>findByIdLog(int id);


}
