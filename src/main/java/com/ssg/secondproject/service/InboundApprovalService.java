package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.ApprovalRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;

public interface InboundApprovalService {

    PageListResponseDTO<ApprovalResponseDTO> getApprovalById(int inboundId);

    void createApprovalStatus(int approverId, ApprovalRequestDTO requestDTO);

    void processCompleteApproval(int approverId, ApprovalRequestDTO requestDTO);

}
