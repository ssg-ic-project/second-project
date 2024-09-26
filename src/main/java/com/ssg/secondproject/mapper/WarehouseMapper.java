package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.Warehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    int insert(Warehouse warehouse);

    List<Warehouse> selectAll();

    Warehouse find(Integer id);

    void delete(Integer id);

    void update(Warehouse warehouse);
}
