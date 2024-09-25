package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.domain.Outbound;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
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
    private OutboundMapper outboundMapper;


    @Override
    public PageResponseDTO<OutboundResponseDTO> getList(PageRequestDTO pageRequestDTO) {
        List<Outbound> outboundList = outboundMapper.findList(pageRequestDTO);
        //DB에서 반환해준 결과값이 outboundList임
        List<OutboundResponseDTO> outboundDTOList = outboundList.stream()
                .map(outbound -> modelMapper.map(outbound, OutboundResponseDTO.class))
                .collect(Collectors.toList());

        int total = outboundMapper.getCount(pageRequestDTO);
        PageResponseDTO<OutboundResponseDTO> pageResponseDTO =PageResponseDTO.<OutboundResponseDTO>withAll()
                .dtoList(outboundDTOList)
                .total(total)
                .pageRequestDTO(pageRequestDTO).build();

        return pageResponseDTO;
    }


//    @Override
//    public List<OutboundResponseDTO> getAll(OutboundRequestDTO outboundRequestDTO) {
//        return null;
//    }


}
