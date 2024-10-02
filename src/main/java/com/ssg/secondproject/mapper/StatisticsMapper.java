package com.ssg.secondproject.mapper;

import com.ssg.secondproject.dto.MonthlyStatsDTO;
import com.ssg.secondproject.dto.SixMonthsStatsDTO;
import com.ssg.secondproject.dto.WarehouseStatsDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticsMapper {

    MonthlyStatsDTO getMonthlyStats();

    List<SixMonthsStatsDTO> getSixMonthsStats();

    WarehouseStatsDTO getWarehouseCapacity();
}
