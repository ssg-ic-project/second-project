package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.request.InboundApprovalRequestDTO;
import com.ssg.secondproject.dto.request.StockLogRequestDTO;
import com.ssg.secondproject.mapper.InboundApprovalMapper;
import com.ssg.secondproject.mapper.StockLogMapper;
import com.ssg.secondproject.service.InboundApprovalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class InboundApprovalServiceImpl implements InboundApprovalService {

    private final InboundApprovalMapper inboundApprovalMapper;
    private final StockLogMapper stockLogMapper;

    @Override
    public void createApprovalStatus(int approverId, InboundApprovalRequestDTO requestDTO) {
        inboundApprovalMapper.insert(approverId, requestDTO);
    }


    @Override
    @Transactional
    public void processCompleteApproval(int approverId, InboundApprovalRequestDTO requestDTO) {
        // 입고 완료
        completeInbound(approverId, requestDTO);
        // 재고 로그 적재
        createStockLog(requestDTO);

    }

    /**
     * 입고 승인 내역은 트랜잭션과 별도로 관리되어야 하므로,
     * processCompleteApproval 에서 트랜잭션이 롤백되더라도 입고 승인 내역은 유지되도록 하기 위해
     * Propagation.REQUIRES_NEW 를 적용하여 별도 트랜잭션으로 처리.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void completeInbound(int approverId, InboundApprovalRequestDTO requestDTO) {
        createApprovalStatus(approverId, requestDTO);
    }

    private void createStockLog(InboundApprovalRequestDTO requestDTO) {
        StockLogRequestDTO stockLogRequestDTO =
            StockLogRequestDTO.builder()
                .inboundId(requestDTO.getInboundId())
                .build();

        log.info("❗️stockLogRequestDTO\n"  +stockLogRequestDTO);

        stockLogMapper.insertInboundLog(stockLogRequestDTO);
    }
}
