package com.ssg.secondproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/outbound")
public class OutboundController {

    @GetMapping("/index")
    public String outbound() {
        return "outbound/index";
    }

}
