package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.*;

import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import java.time.LocalDate;

public interface OutboundService {
    PageListResponseDTO<OutboundResponseDTO> getList(PageRequestDTO pageRequestDTO);

    //출고 요청서 상세 페이지 데이터 가지고 오기
    PageResponseDTO<OutboundDetailResponseDTO> getById(int id);

    //출고 요청서 상세 페이지 내에 출고 승인 내역 데이터 가지고 오기
    PageResponseDTO<ApprovalResponseDTO> getByIdLog(int id);

    PageListResponseDTO<OutboundDetailResponseDTO> getByUserInput(PageRequestDTO pageRequestDTO, String warehouseName, String approvalStatus, LocalDate startDate, LocalDate endDate);


}
