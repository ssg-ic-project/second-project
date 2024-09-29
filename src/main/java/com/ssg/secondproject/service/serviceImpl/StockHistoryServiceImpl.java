package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.StockHistoryDTO;
import com.ssg.secondproject.dto.request.WarehouseRequestDTO;
import com.ssg.secondproject.mapper.StockHistoryMapper;
import com.ssg.secondproject.service.StockHistoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockHistoryServiceImpl implements StockHistoryService {

    private final StockHistoryMapper stockHistoryMapper;

    private final ModelMapper modelMapper;

    @Override
    public List<StockHistoryDTO> list() {

        List<StockHistoryDTO> stockHistoryDTOList = stockHistoryMapper.selectAll()
                .stream().map(vo -> modelMapper.map(vo, StockHistoryDTO.class)).collect(Collectors.toList());

        return stockHistoryDTOList;
    }
}
