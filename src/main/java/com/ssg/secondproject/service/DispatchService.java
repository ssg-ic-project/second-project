package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.DispatchDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;

public interface DispatchService {

    PageResponseDTO<DispatchDTO> getById(int id);

    void update(DispatchDTO dispatchDTO);

}
