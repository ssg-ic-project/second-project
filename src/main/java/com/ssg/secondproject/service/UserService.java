package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.UserResponseDTO;

public interface UserService {

    PageListResponseDTO<UserResponseDTO> getList(PageRequestDTO pageRequestDTO);

}
