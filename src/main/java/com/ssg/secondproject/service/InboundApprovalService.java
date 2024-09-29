package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.InboundApprovalRequestDTO;

public interface InboundApprovalService {

    void createApprovalStatus (int approverId, InboundApprovalRequestDTO requestDTO);

}
