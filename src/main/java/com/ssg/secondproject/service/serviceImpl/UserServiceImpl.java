package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.domain.User;
import com.ssg.secondproject.domain.UserApproval;
import com.ssg.secondproject.dto.PageInfoDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.UserResponseDTO;
import com.ssg.secondproject.mapper.UserMapper;
import com.ssg.secondproject.service.UserService;
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

        List<UserResponseDTO> dtoList = userMapper.findAll(pageRequestDTO);

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
    public PageListResponseDTO<ApprovalResponseDTO> getApprovalByUserId(int userId) {
        List<UserApproval> voList = userMapper.findApprovalByUserId(userId);

        List<ApprovalResponseDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo, ApprovalResponseDTO.class))
            .collect(Collectors.toList());

        PageListResponseDTO<ApprovalResponseDTO> pageResponseDTO =
            PageListResponseDTO.<ApprovalResponseDTO>builder()
                .dataList(dtoList)
                .build();

        return pageResponseDTO;
    }
}
