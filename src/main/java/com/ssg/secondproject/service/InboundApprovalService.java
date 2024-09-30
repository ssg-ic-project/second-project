package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.InboundApprovalRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;

public interface InboundApprovalService {

    PageListResponseDTO<ApprovalResponseDTO> getApprovalById(int inboundId);

    void createApprovalStatus(int approverId, InboundApprovalRequestDTO requestDTO);

    void processCompleteApproval(int approverId, InboundApprovalRequestDTO requestDTO);

}
