package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.request.DeliveryRequestDTO;
import com.ssg.secondproject.dto.request.OutboundApprovalRequestDTO;
import com.ssg.secondproject.dto.request.StockLogRequestDTO;
import com.ssg.secondproject.mapper.DeliveryMapper;
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
    private final DeliveryMapper inDeliveryMapper;

    //출고 승인 후 insert
    @Override
    public void approveOutbound(int id, OutboundApprovalRequestDTO requestDTO) {
        outboundApprovalMapper.insertOutboundApproval(id, requestDTO);
        //배송에 PENDING 넣어주기
        DeliveryRequestDTO deliveryRequestDTO = DeliveryRequestDTO.builder()
                .outboundId(requestDTO.getOutboundId())
                .build();
        inDeliveryMapper.insertDeliveryStatus(deliveryRequestDTO);
    }

    @Transactional
    @Override
    public void completeOutbound(int id, OutboundApprovalRequestDTO requestDTO) {

        //approveOutbound로 OutboundApproval 테이블에 log 데이터 쌓기
        processOutbound(id, requestDTO);

        //StockLog 테이블에 출고 내역 쌓기
        stockLog(requestDTO);

        //배송 상태 IN_DELIVERY로 바꾸기--> 확장: 차량이 80%찰경우 배송 가능이기 떄문에 그쪽에 붙어야 함.
        //processDelivery(requestDTO);

        //운송장 등록하기
        createInvoice(requestDTO);

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
    //delivery in_delivery status로 바꿔주기
    public void processDelivery(OutboundApprovalRequestDTO requestDTO){
        inDeliveryMapper.updateDeliveryStatus(requestDTO);
        //PENDING -> IN_DELIVERY로는 update해주면 됨.
    }

    //운송장 등록하기
    public void createInvoice(OutboundApprovalRequestDTO requestDTO){
        outboundApprovalMapper.insertInvoice(requestDTO);
    };

}
