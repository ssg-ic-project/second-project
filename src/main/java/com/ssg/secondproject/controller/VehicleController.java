package com.ssg.secondproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @GetMapping("/index")
    public String vehicle() {
        return "vehicle/index";
    }

}
