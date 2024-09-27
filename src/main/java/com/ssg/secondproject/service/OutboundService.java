package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;

import java.util.List;

public interface OutboundService {
    PageListResponseDTO<OutboundResponseDTO> getList(PageRequestDTO pageRequestDTO);
    //출고 요청서 상세 페이지 데이터 가지고 오기
    PageResponseDTO<OutboundResponseDTO> getById(int id);
    //출고 요청서 상세 페이지 내에 출고 승인 내역 데이터 가지고 오기
    PageResponseDTO<OutboundResponseDTO> getByIdLog(int id);

}
