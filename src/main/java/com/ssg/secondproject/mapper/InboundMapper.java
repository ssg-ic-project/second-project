package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.InboundDetailResponseDTO;
import com.ssg.secondproject.dto.response.InboundResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InboundMapper {

    List<InboundResponseDTO> findAll(PageRequestDTO pageRequestDTO);

    InboundDetailResponseDTO findById(int id);


}
