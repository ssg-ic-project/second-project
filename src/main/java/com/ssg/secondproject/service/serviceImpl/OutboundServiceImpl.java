package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.PageInfoDTO;
import com.ssg.secondproject.dto.request.OutboundApprovalRequestDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.*;
import com.ssg.secondproject.mapper.OutboundMapper;
import com.ssg.secondproject.service.OutboundService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OutboundServiceImpl implements OutboundService {
    private final ModelMapper modelMapper;
    private final OutboundMapper outboundMapper;

    @Override
    public PageListResponseDTO<OutboundResponseDTO> getList(PageRequestDTO pageRequestDTO) {
        List<OutboundResponseDTO> outboundList = outboundMapper.findList(pageRequestDTO);
        //DB에서 반환해준 결과값이 outboundList임
//        List<OutboundResponseDTO> outboundDTOList = outboundList.stream()
//                .map(outbound -> modelMapper.map(outbound, OutboundResponseDTO.class))
//                .collect(Collectors.toList());
        int total = outboundMapper.getCount(pageRequestDTO);

        PageInfoDTO pageInfoDTO =
                PageInfoDTO.withAll()
                        .pageRequestDTO(pageRequestDTO)
                        .total(total)
                        .build();

        PageListResponseDTO<OutboundResponseDTO> pageResponseDTO = PageListResponseDTO.<OutboundResponseDTO>builder()
                .pageInfoDTO(pageInfoDTO)
                .dataList(outboundList)
                .build();
        return pageResponseDTO;
    }

    @Override
    public PageResponseDTO<OutboundDetailResponseDTO> getById(int id) {
        OutboundDetailResponseDTO outboundData = outboundMapper.findById(id);
        PageResponseDTO pageResponseDTO = PageResponseDTO.builder().data(outboundData).build();
        return pageResponseDTO;
    }

    @Override
    public PageResponseDTO<ApprovalResponseDTO> getByIdLog(int id) {
        List<ApprovalResponseDTO> outboundData = outboundMapper.findByIdLog(id);
        PageResponseDTO pageResponseDTO = PageResponseDTO.builder().data(outboundData).build();
        return pageResponseDTO;
    }

    @Override
    public PageListResponseDTO<OutboundDetailResponseDTO> getByUserInput(PageRequestDTO pageRequestDTO, String warehouseName, String approvalStatus, LocalDate startDate, LocalDate endDate) {
        List<OutboundDetailResponseDTO> outboundData = outboundMapper.findByUserInput(warehouseName, approvalStatus, startDate, endDate);

        int total = outboundMapper.getCount(pageRequestDTO);

        PageInfoDTO pageInfoDTO =
                PageInfoDTO.withAll()
                        .pageRequestDTO(pageRequestDTO)
                        .total(total)
                        .build();

        PageListResponseDTO<OutboundDetailResponseDTO> pageResponseDTO = PageListResponseDTO.<OutboundDetailResponseDTO>builder()
                .pageInfoDTO(pageInfoDTO)
                .dataList(outboundData)
                .build();

        return pageResponseDTO;
    }




}
