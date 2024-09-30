package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.StockUpdateRequestDTO;
import com.ssg.secondproject.service.StockLogService;
import com.ssg.secondproject.service.StockService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockRestController {

    private final StockService stockService;

    @GetMapping("/list")
    public ResponseEntity<?> getList(@RequestParam Map<String, Object> paramMap, @PageableDefault Pageable pageable) {
        Map<String, Object> resultMap = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime fromDate = LocalDate.parse(paramMap.get("from").toString(), formatter).atStartOfDay();
        LocalDateTime toDate = LocalDate.parse(paramMap.get("to").toString(), formatter).atTime(LocalTime.MAX);;


        log.info(fromDate);
        log.info(toDate);

        log.info("paramMap" + paramMap);

        paramMap.put("from", fromDate);
        paramMap.put("to", toDate);

        Page<Map<String, Object>> result = stockService.list(paramMap, pageable);
        resultMap.put("pages", result);
        resultMap.put("size", pageable.getPageSize());


        log.info("Result = " + result);

        return ResponseEntity.ok().body(resultMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody StockUpdateRequestDTO stockUpdateRequestDTO) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("id", id);
        responseMap.put("actualQuantity", stockUpdateRequestDTO.getActualQuantity());
        responseMap.put("remarks", stockUpdateRequestDTO.getRemarks());

        stockService.update(responseMap);

        return ResponseEntity.ok().build();
    }
}
