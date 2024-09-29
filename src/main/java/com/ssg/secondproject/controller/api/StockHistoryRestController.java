package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.StockHistoryDTO;
import com.ssg.secondproject.service.StockHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/stockhistory")
public class StockHistoryRestController {

    private final StockHistoryService stockHistoryService;

    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        List<StockHistoryDTO> result = stockHistoryService.list();

        log.info("Result = " + result);

        return ResponseEntity.ok().body(result);
    }
}
