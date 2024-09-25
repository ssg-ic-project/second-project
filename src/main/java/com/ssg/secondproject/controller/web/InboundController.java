package com.ssg.secondproject.controller.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/inbound")
public class InboundController {

    @GetMapping("/index")
    public String inbound() {
        log.info(" 🎉🎉🎉🎉 Inbound Index 🎉🎉🎉🎉 ");
        return "inbound/index";
    }

    @GetMapping()
    public String inboundDetail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        log.info(" 🎉🎉🎉🎉 Inbound Detail 🎉🎉🎉🎉\n ID:  " + id);
        return "inbound/detail"; // user>detail.html로 이동
    }

}
