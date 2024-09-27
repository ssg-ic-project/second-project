package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.WarehouseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface WarehouseService {
    int create(WarehouseDTO warehouseDTO);

    WarehouseDTO get(int id);

    void update(WarehouseDTO warehouseDTO);

//    List<WarehouseDTO> getList();
    Page<Map<String, Object>> getList (Map<String, Object> paramMap, Pageable page);
}