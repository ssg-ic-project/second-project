package com.ssg.secondproject.mapper;

import com.ssg.secondproject.domain.Warehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WarehouseMapper {
    int insert(Warehouse warehouse);

    List<Map<String, Object>> selectAll(Map<String, Object> paramMap);

    Warehouse find(int id);

    void delete(int id);

    int count();

    void update(Warehouse warehouse);

    Warehouse findName();
}
