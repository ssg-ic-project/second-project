package com.ssg.secondproject.service;

import com.ssg.secondproject.domain.Admin;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import java.util.List;

public interface AdminService {

    PageResponseDTO<AdminResponseDTO> getAll(PageRequestDTO pageRequestDTO);
}