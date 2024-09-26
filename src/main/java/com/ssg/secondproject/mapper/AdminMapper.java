package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.Admin;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    int getAdminCnt(PageRequestDTO pageRequestDTO);

    List<Admin> findAll(PageRequestDTO pageRequestDTO);

    AdminResponseDTO findById(int id);

}
