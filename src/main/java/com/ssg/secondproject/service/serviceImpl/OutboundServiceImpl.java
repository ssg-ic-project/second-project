package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.domain.Outbound;
import com.ssg.secondproject.dto.PageInfoDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.mapper.OutboundMapper;
import com.ssg.secondproject.service.OutboundService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
}
