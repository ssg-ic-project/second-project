package com.ssg.secondproject.controller.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Log4j2
public class DashboardController {

    @GetMapping("/index")
    public String dashboard() {
        log.info(" 🎉🎉🎉🎉 dashboard 🎉🎉🎉🎉 ");
        return "index";
    }
}