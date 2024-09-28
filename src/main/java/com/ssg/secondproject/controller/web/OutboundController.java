package com.ssg.secondproject.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/outbound")
@RequiredArgsConstructor
public class OutboundController {

    @GetMapping("/index")
    public String outbound() {
        return "outbound/index";
    }

    @GetMapping("/detail")
    public String outbound_detail() {
        return "outbound/detail";
    }


}
