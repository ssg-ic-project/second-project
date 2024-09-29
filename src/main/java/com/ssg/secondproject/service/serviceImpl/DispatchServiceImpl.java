package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.response.DispatchResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.mapper.DispatchMapper;
import com.ssg.secondproject.service.DispatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DispatchServiceImpl implements DispatchService {
    private final DispatchMapper dispatchMapper;

    @Override
    public PageResponseDTO<DispatchResponseDTO> getById(int id) {
        DispatchResponseDTO dispatchData = dispatchMapper.findById(id);
        PageResponseDTO pageResponseDTO = PageResponseDTO.builder().data(dispatchData).build();

        return pageResponseDTO;
    }
}
