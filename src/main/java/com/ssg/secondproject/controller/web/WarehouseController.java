package com.ssg.secondproject.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @GetMapping("/index")
    public String warehouse() {
        return "warehouse/index";
    }

    @GetMapping("/detail")
    public String warehouseDetail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "warehouse/detail";
    }
}
