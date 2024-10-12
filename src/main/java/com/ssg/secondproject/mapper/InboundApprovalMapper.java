package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.request.ApprovalRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InboundApprovalMapper {

    List<ApprovalResponseDTO> findApprovalById(int inboundId);

    void insert(@Param("approverId") int approverId, @Param("requestDTO") ApprovalRequestDTO requestDTO);

}
