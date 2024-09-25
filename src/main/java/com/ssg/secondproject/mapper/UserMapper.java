package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    List<User> findAll();

}
