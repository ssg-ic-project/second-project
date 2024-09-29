package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.request.OutboundApprovalRequestDTO;
import com.ssg.secondproject.dto.request.StockLogRequestDTO;
import com.ssg.secondproject.mapper.OutboundApprovalMapper;
import com.ssg.secondproject.mapper.StockMapper;
import com.ssg.secondproject.service.OutboundApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OutboundApprovalServiceImpl implements OutboundApprovalService {

    private final OutboundApprovalMapper outboundApprovalMapper;
    private final StockMapper stockMapper;

    //출고 승인 후 insert
    @Override
    public void approveOutbound(int id, OutboundApprovalRequestDTO requestDTO) {
        outboundApprovalMapper.insertOutboundApproval(id, requestDTO);
    }

    @Transactional
    @Override
    public void completeOutbound(int id, OutboundApprovalRequestDTO requestDTO) {

        //approveOutbound로 OutboundApproval 테이블에 log 데이터 쌓기
        processOutbound(id, requestDTO);

        //StockLog 테이블에 출고 내역 쌓기
        stockLog(requestDTO);
    }

    //completeOutbound는 rollback과 상관없이 logging이 되어야 함
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processOutbound(int id, OutboundApprovalRequestDTO requestDTO){
        approveOutbound(id, requestDTO);
    }

    public void stockLog(OutboundApprovalRequestDTO requestDTO){
        StockLogRequestDTO stockLogRequestDTO = StockLogRequestDTO
                .builder()
                .outboundId(requestDTO.getOutboundId())
                .build();
        stockMapper.insertOutboundLog(stockLogRequestDTO);
    }



}
