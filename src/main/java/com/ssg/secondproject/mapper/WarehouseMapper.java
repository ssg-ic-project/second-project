package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.WarehouseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    void insert(WarehouseVO warehouseVO);

    List<WarehouseVO> selectAll();

    WarehouseVO get(Integer id);

    void delete(Integer id);

    void update(WarehouseVO warehouseVO);
}
