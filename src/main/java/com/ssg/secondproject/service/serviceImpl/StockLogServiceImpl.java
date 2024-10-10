package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.mapper.StockLogMapper;
import com.ssg.secondproject.service.StockLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StockLogServiceImpl implements StockLogService {

    private final StockLogMapper stockLogMapper;

    @Override
    public Page<Map<String, Object>> list(Map<String, Object> paramMap, Pageable pageable) {
        paramMap.put("offset", pageable.getOffset());
        paramMap.put("pageSize", pageable.getPageSize());

        List<Map<String, Object>> list = stockLogMapper.selectAll(paramMap);
        int count = stockLogMapper.count();
        return new PageImpl<>(list,pageable, count);
    }
}
