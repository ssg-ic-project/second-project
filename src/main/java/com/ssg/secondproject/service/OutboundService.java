package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;

import java.util.List;

public interface OutboundService {

//    List<OutboundDTO> getAll(OutboundRequestDTO outboundRequestDTO);

    PageResponseDTO<OutboundResponseDTO> getList(PageRequestDTO pageRequestDTO);
}
