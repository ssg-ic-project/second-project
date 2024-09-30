package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.DispatchDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DispatchMapper {

    DispatchDTO findById(int id);
    void updateDispatch(DispatchDTO dispatchDTO);
}
