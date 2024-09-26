package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;

public interface AdminService {

    PageListResponseDTO<AdminResponseDTO> getList(PageRequestDTO pageRequestDTO);

    PageResponseDTO<AdminResponseDTO> getById(int id);
}