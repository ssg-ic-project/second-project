package com.ssg.secondproject.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dispatch")
public class DispatchController {

    @GetMapping("/index")
    public String dispatch() {
        return "dispatch/index";
    }

}
