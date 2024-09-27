package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.domain.User;
import com.ssg.secondproject.domain.UserApproval;
import com.ssg.secondproject.dto.PageInfoDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.dto.response.UserApprovalResponseDTO;
import com.ssg.secondproject.dto.response.UserResponseDTO;
import com.ssg.secondproject.mapper.UserMapper;
import com.ssg.secondproject.service.UserService;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserMapper userMapper;

    @Override
    public PageListResponseDTO<UserResponseDTO> getList(PageRequestDTO pageRequestDTO) {
        int total = userMapper.getUserCnt(pageRequestDTO);

        List<User> voList = userMapper.findAll(pageRequestDTO);
        List<UserResponseDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo, UserResponseDTO.class))
            .collect(Collectors.toList());

        PageInfoDTO pageInfoDTO =
            PageInfoDTO.withAll()
                .pageRequestDTO(pageRequestDTO)
                .total(total)
                .build();

        PageListResponseDTO<UserResponseDTO> pageResponseDTO =
            PageListResponseDTO.<UserResponseDTO>builder()
                .pageInfoDTO(pageInfoDTO)
                .dataList(dtoList)
                .build();

        return pageResponseDTO;

    }

    @Override
    public PageResponseDTO<UserResponseDTO> getById(int id) {
        User user = userMapper.findById(id);

        UserResponseDTO userResponseDTO = modelMapper.map(user, UserResponseDTO.class);
        PageResponseDTO<UserResponseDTO> responseDTO = PageResponseDTO.<UserResponseDTO>builder().data(userResponseDTO).build();

        return responseDTO;
    }

    @Override
    public PageListResponseDTO<UserApprovalResponseDTO> getApprovalByUserId(int userId) {
//        int total = userMapper.getApprovalCnt(userId);

//        List<UserApproval> voList = userMapper.findApprovalByUserId(userId);

//        List<UserApprovalResponseDTO> dtoList = userMapper.findApprovalByUserId(userId);

//        PageInfoDTO pageInfoDTO =
//            PageInfoDTO.withAll()
//                .total(total)
//                .build();

//        PageListResponseDTO<UserApprovalResponseDTO> pageResponseDTO =
//            PageListResponseDTO.builder()
////                .pageInfoDTO(pageInfoDTO)
//                .dataList(Collections.singletonList(dtoList))
//                .build();

        return null;
    }
}
