package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.User;
import com.ssg.secondproject.domain.UserApproval;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int getUserCnt(PageRequestDTO pageRequestDTO);

    List<User> findAll(PageRequestDTO pageRequestDTO);

    User findById(int id);

    List<UserApproval> findApprovalByUserId(int userId);

}
