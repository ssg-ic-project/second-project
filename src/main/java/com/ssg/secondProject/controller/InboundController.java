package com.ssg.secondProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inbound")
public class InboundController {

    @GetMapping("/index")
    public String inbound() {
        return "inbound/index";
    }

}
