package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.request.DeliveryRequestDTO;
import com.ssg.secondproject.dto.request.OutboundApprovalRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {
    void insertDeliveryStatus(DeliveryRequestDTO deliveryRequestDTO);
    void updateDeliveryStatus(OutboundApprovalRequestDTO requestDTO);

}
