package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.UserResponseDTO;

public interface UserService {

    PageListResponseDTO<UserResponseDTO> getList(PageRequestDTO pageRequestDTO);

    PageResponseDTO<UserResponseDTO> getById(int id);

    PageListResponseDTO<ApprovalResponseDTO> getApprovalByUserId(int userId);
}
