package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.request.InboundApprovalRequestDTO;
import com.ssg.secondproject.mapper.InboundApprovalMapper;
import com.ssg.secondproject.service.InboundApprovalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class InboundApprovalServiceImpl implements InboundApprovalService {

    private final InboundApprovalMapper inboundApprovalMapper;

    @Override
    public void createApprovalStatus(int approverId, InboundApprovalRequestDTO requestDTO) {
        inboundApprovalMapper.insert(approverId, requestDTO);
    }
}