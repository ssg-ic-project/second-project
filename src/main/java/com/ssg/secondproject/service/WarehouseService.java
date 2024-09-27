package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.WarehouseDTO;

import java.util.List;

public interface WarehouseService {
    int create(WarehouseDTO warehouseDTO);

    WarehouseDTO get(int id);

    void update(WarehouseDTO warehouseDTO);

    List<WarehouseDTO> getList();
}