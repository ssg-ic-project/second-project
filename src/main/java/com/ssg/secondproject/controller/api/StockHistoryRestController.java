package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.StockHistoryDTO;
import com.ssg.secondproject.service.StockHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/stockhistory")
public class StockHistoryRestController {

    private final StockHistoryService stockHistoryService;

    @GetMapping("/list")
    public ResponseEntity<?> getList(@RequestParam Map<String, Object> paramMap, @PageableDefault Pageable pageable) {
        Map<String, Object> resultMap = new HashMap<>();

        Page<Map<String, Object>> result = stockHistoryService.list(paramMap, pageable);
        resultMap.put("pages", result);
        resultMap.put("size", pageable.getPageSize());


        log.info("Result = " + result);

        return ResponseEntity.ok().body(resultMap);
    }
}
