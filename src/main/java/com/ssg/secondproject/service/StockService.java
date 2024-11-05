package com.ssg.secondproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface StockService {
    Page<Map<String, Object>> list(Map<String, Object> paramMap, Pageable pageable);

    void update(Map<String, Object> updateMap);
}
