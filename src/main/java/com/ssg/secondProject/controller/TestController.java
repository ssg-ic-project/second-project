package com.ssg.secondProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class TestController {

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/warehouse")
    public String warehousePage() {
        return "warehouse/index";
    }
}
