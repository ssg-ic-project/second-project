package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.Admin;
import com.ssg.secondproject.dto.request.AdminRequestDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

    int getAdminCnt(PageRequestDTO requestDTO);

    List<Admin> findAll(PageRequestDTO requestDTO);

    AdminResponseDTO findById(int id);

    void updateById(@Param("updatedId") int updatedId, @Param("requestDTO") AdminRequestDTO requestDTO);

}
