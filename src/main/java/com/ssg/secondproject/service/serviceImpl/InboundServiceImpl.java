package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.InboundDetailResponseDTO;
import com.ssg.secondproject.dto.response.InboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.mapper.InboundMapper;
import com.ssg.secondproject.service.InboundService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InboundServiceImpl implements InboundService {

    private final ModelMapper modelMapper;
    private final InboundMapper inboundMapper;

    @Override
    public PageListResponseDTO<InboundResponseDTO> getList(PageRequestDTO pageRequestDTO) {

        List<InboundResponseDTO> dtoList = inboundMapper.findAll(pageRequestDTO);

        PageListResponseDTO<InboundResponseDTO> pageResponseDTO =
            PageListResponseDTO.<InboundResponseDTO>builder()
                .dataList(dtoList)
                .build();

        return pageResponseDTO;
    }

    @Override
    public PageResponseDTO<InboundDetailResponseDTO> getById(int id) {
        return null;
    }

    @Override
    public PageListResponseDTO<ApprovalResponseDTO> getApprovalById(int inboundId) {
        return null;
    }
}
