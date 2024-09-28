package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.domain.Warehouse;
import com.ssg.secondproject.dto.WarehouseDTO;
import com.ssg.secondproject.mapper.WarehouseMapper;
import com.ssg.secondproject.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final ModelMapper modelMapper;

    private final WarehouseMapper warehouseMapper;

    @Override
    public WarehouseDTO get(Integer id) {
        Warehouse warehouse = warehouseMapper.find(id);

        WarehouseDTO warehouseDTO = modelMapper.map(warehouse, WarehouseDTO.class);

        return warehouseDTO;
    }

    @Override
    public int create(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = modelMapper.map(warehouseDTO, Warehouse.class);

        int result = warehouseMapper.insert(warehouse);

        return result;
    }
}
