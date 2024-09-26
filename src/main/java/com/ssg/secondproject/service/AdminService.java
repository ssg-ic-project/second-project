package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;

public interface AdminService {

    PageListResponseDTO<AdminResponseDTO> getList(PageRequestDTO pageRequestDTO);
}