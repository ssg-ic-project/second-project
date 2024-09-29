package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.response.DispatchResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;

public interface DispatchService {

    PageResponseDTO<DispatchResponseDTO> getById(int id);
}
