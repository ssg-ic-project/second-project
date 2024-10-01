package com.ssg.secondproject.service;


import com.ssg.secondproject.dto.request.OutboundApprovalRequestDTO;

public interface OutboundApprovalService {

    void approveOutbound(int id, OutboundApprovalRequestDTO requestDTO);
    void completeOutbound(int id, OutboundApprovalRequestDTO requestDTO);

    void processDelivery(OutboundApprovalRequestDTO requestDTO);

    void createInvoice(OutboundApprovalRequestDTO requestDTO);

    //다른 방법
//    void modifyStatus(@Param("id") int id, OutboundRequestDTO outboundRequestDTO);


}
