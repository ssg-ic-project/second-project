package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.Outbound;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutboundMapper {
    List<OutboundResponseDTO>findList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
    OutboundResponseDTO findById(int id);
    OutboundResponseDTO findByIdLog(int id);



}
