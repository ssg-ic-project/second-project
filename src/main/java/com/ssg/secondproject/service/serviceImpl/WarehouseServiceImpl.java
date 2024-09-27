package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.domain.Warehouse;
import com.ssg.secondproject.dto.WarehouseDTO;
import com.ssg.secondproject.mapper.WarehouseMapper;
import com.ssg.secondproject.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<WarehouseDTO> getList() {
        List<Warehouse> warehouseList = warehouseMapper.selectAll();

        return warehouseList.stream().map(
                vo -> modelMapper.map(vo, WarehouseDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public int create(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = modelMapper.map(warehouseDTO, Warehouse.class);

        int result = warehouseMapper.insert(warehouse);

        return result;
    }
}
