package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.DispatchDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;

public interface DispatchService {

    PageResponseDTO<DispatchDTO> getById(int id);

    void insert(int approvalId, int outboundId, int vehicleId, String vehicleType);

}
