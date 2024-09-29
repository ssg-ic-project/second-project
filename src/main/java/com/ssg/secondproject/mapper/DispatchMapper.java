package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.response.DispatchResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DispatchMapper {

    DispatchResponseDTO findById(int id);
}
