package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.domain.Warehouse;
import com.ssg.secondproject.dto.WarehouseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.WarehouseNameResponseDTO;
import com.ssg.secondproject.mapper.WarehouseMapper;
import com.ssg.secondproject.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final ModelMapper modelMapper;

    private final WarehouseMapper warehouseMapper;

    @Override
    public WarehouseDTO get(int id) {
        Warehouse warehouse = warehouseMapper.find(id);

        WarehouseDTO warehouseDTO = modelMapper.map(warehouse, WarehouseDTO.class);

        return warehouseDTO;
    }

    @Override
    public void update(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = modelMapper.map(warehouseDTO, Warehouse.class);

        warehouseMapper.update(warehouse);
    }

//    @Override
//    public List<WarehouseDTO> getList() {
//        List<Warehouse> warehouseList = warehouseMapper.selectAll();
//
//        return warehouseList.stream().map(
//                vo -> modelMapper.map(vo, WarehouseDTO.class)
//        ).collect(Collectors.toList());
//    }

    @Override
    public Page<Map<String, Object>> getList(Map<String, Object> paramMap, Pageable page) {
        paramMap.put("offset",page.getOffset());
        paramMap.put("pageSize",page.getPageSize());
        List<Map<String, Object>> contents = warehouseMapper.selectAll(paramMap);
        int count = warehouseMapper.count();
        return new PageImpl<>(contents,page,count);
    }

    @Override
    public PageListResponseDTO<WarehouseNameResponseDTO> getNameList() {
        List<Warehouse> voList = warehouseMapper.findName();

        List<WarehouseNameResponseDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo, WarehouseNameResponseDTO.class))
            .collect(Collectors.toList());

        PageListResponseDTO<WarehouseNameResponseDTO> pageResponseDTO =
            PageListResponseDTO.<WarehouseNameResponseDTO>builder()
                .dataList(dtoList)
                .build();

        return pageResponseDTO;
    }

    @Override
    public int create(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = modelMapper.map(warehouseDTO, Warehouse.class);

        int result = warehouseMapper.insert(warehouse);

        return result;
    }
}
