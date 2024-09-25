package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.Admin;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    List<Admin> findAll();

}
