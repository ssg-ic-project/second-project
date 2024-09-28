package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.InboundDetailResponseDTO;
import com.ssg.secondproject.dto.response.InboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;

public interface InboundService {
    PageListResponseDTO<InboundResponseDTO> getList (PageRequestDTO pageRequestDTO);

    PageResponseDTO<InboundDetailResponseDTO> getById (int id);

    PageListResponseDTO<ApprovalResponseDTO> getApprovalById (int inboundId);

}
