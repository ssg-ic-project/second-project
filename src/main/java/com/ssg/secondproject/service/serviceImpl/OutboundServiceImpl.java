package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.PageInfoDTO;
import com.ssg.secondproject.dto.request.OutboundRequestDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.dto.response.UserResponseDTO;
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
    public PageResponseDTO<OutboundResponseDTO> getById(int id) {
        OutboundResponseDTO outboundData = outboundMapper.findById(id);
        PageResponseDTO pageResponseDTO = PageResponseDTO.builder().data(outboundData).build();
        return pageResponseDTO;
    }

    @Override
    public PageResponseDTO<OutboundResponseDTO> getByIdLog(int id) {
        List<OutboundResponseDTO> outboundData = outboundMapper.findByIdLog(id);
        PageResponseDTO pageResponseDTO = PageResponseDTO.builder().data(outboundData).build();
        return pageResponseDTO;
    }

    @Override
    public PageListResponseDTO<OutboundResponseDTO> getByUserInput(PageRequestDTO pageRequestDTO, String warehouseName, String approvalStatus, LocalDate startDate, LocalDate endDate) {
        List<OutboundResponseDTO> outboundData = outboundMapper.findByUserInput(warehouseName, approvalStatus, startDate, endDate);

        int total = outboundMapper.getCount(pageRequestDTO);

        PageInfoDTO pageInfoDTO =
                PageInfoDTO.withAll()
                        .pageRequestDTO(pageRequestDTO)
                        .total(total)
                        .build();

        PageListResponseDTO<OutboundResponseDTO> pageResponseDTO = PageListResponseDTO.<OutboundResponseDTO>builder()
                .pageInfoDTO(pageInfoDTO)
                .dataList(outboundData)
                .build();

        return pageResponseDTO;
    }

    @Override
    public void modifyStatus(int id, String approvalStatus, Long rejectionReason ) {
        OutboundRequestDTO outboundRequestDTO = OutboundRequestDTO.builder()
                .outboundId(id)
                .status(approvalStatus)
                .rejectionReason(rejectionReason)
                .build();

        outboundMapper.updateStatus(outboundRequestDTO);
    }


}
