package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.PageInfoDTO;
import com.ssg.secondproject.dto.request.AdminRequestDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.mapper.AdminMapper;
import com.ssg.secondproject.service.AdminService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    @Override
    public PageListResponseDTO<AdminResponseDTO> getList(PageRequestDTO pageRequestDTO) {

        int total = adminMapper.getAdminCnt(pageRequestDTO);

        List<AdminResponseDTO> dtoList = adminMapper.findAll(pageRequestDTO);

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

    @Override
    public PageResponseDTO<AdminResponseDTO> getById(int id) {
        AdminResponseDTO data = adminMapper.findById(id);

        PageResponseDTO responseDTO = PageResponseDTO.builder().data(data).build();
        return responseDTO;
    }

    @Override
    public void modifyById(int id, AdminRequestDTO requestDTO) {
        adminMapper.updateById(id, requestDTO);
    }
}