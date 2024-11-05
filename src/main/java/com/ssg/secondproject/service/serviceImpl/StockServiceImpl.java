package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.mapper.StockMapper;
import com.ssg.secondproject.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockMapper stockMapper;

    @Override
    public Page<Map<String, Object>> list(Map<String, Object> paramMap, Pageable pageable) {
        paramMap.put("offset", pageable.getOffset());
        paramMap.put("pageSize", pageable.getPageSize());

        List<Map<String, Object>> list = stockMapper.selectAll(paramMap);
        int count = stockMapper.count();
        return new PageImpl<>(list,pageable, count);
    }

    @Override
    public void update(Map<String, Object> updateMap) {
        stockMapper.update(updateMap);
    }
}
