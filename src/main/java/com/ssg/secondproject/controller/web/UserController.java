package com.ssg.secondproject.controller.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/user")
public class UserController {

    @GetMapping("/index")
    public String user() {
        log.info(" 🎉🎉🎉🎉 User Index 🎉🎉🎉🎉 ");
        return "user/index";
    }

    @GetMapping()
    public String adminDetail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        log.info(" 🎉🎉🎉🎉 User Detail 🎉🎉🎉🎉\n ID:  " + id);
        return "user/detail"; // user>detail.html로 이동
    }

}
