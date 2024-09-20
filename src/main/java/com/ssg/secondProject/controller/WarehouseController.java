package com.ssg.secondProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @GetMapping("/index")
    public String warehouse() {
        return "warehouse/index";
    }

}
