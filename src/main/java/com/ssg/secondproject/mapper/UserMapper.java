package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findAll();

}
