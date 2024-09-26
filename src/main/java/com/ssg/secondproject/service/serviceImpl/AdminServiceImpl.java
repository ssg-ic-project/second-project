package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.domain.Admin;
import com.ssg.secondproject.dto.PageInfoDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.mapper.AdminMapper;
import com.ssg.secondproject.service.AdminService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ModelMapper modelMapper;
    private final AdminMapper adminMapper;

    @Override
    public PageListResponseDTO<AdminResponseDTO> getList(PageRequestDTO pageRequestDTO) {

        int total = adminMapper.getAdminCnt(pageRequestDTO);

//        String keyword = pageRequestDTO.getKeyword();
        List<Admin> voList = adminMapper.findAll(pageRequestDTO);
        List<AdminResponseDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo, AdminResponseDTO.class))
            .collect(Collectors.toList());

        PageInfoDTO pageInfoDTO =
            PageInfoDTO.withAll()
                .pageRequestDTO(pageRequestDTO)
                .total(total)
                .build();

        PageListResponseDTO<AdminResponseDTO> pageResponseDTO =
            PageListResponseDTO.<AdminResponseDTO>builder()
                .pageInfoDTO(pageInfoDTO)
                .dataList(dtoList)
                .build();

        return pageResponseDTO;
    }
}