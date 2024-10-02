package com.ssg.secondproject.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/outbound")
@RequiredArgsConstructor
public class OutboundController {

    @GetMapping("/index")
    public String outbound() {
        return "outbound/index";
    }

    @GetMapping()
    public String outbound_detail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "outbound/detail";
    }


}
