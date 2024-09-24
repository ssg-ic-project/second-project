package com.ssg.secondproject.controller.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api/warehouse")
public class WarehouseRestController {
    @GetMapping("/names")
    public String getWarehouseList() {
        log.info(" 🎉🎉🎉🎉 Rest Warehouse List 🎉🎉🎉🎉");
        return """
            {
              "status": "success",
              "data": {
                "warehouseNameList": [
                  { "id": 1, "name": "서울 창고" },
                  { "id": 2, "name": "의정부 창고" },
                  { "id": 3, "name": "남양주 창고" },
                  { "id": 4, "name": "천안 창고" },
                  { "id": 5, "name": "이천 창고" }
                ]
              }
            }
            """;
    }
}
