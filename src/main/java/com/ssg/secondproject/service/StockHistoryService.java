package com.ssg.secondproject.service;

import com.ssg.secondproject.dto.StockHistoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface StockHistoryService {
//    List<StockHistoryDTO> list();
    Page<Map<String, Object>> list(Map<String, Object> paramMap, Pageable pageable);
}
