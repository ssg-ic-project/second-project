package com.ssg.secondproject.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class StockController {

    @GetMapping("/index")
    public String stock() {
        return "stock/index";
    }

}
