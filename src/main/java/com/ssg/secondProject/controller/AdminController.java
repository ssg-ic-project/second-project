package com.ssg.secondProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/index")
    public String admin() {
        return "admin/index"; // resources/templates/admin/index.html 파일을 반환합니다.
    }

    @GetMapping()
    public String adminDetail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "admin/detail"; // user>detail.html로 이동
    }
}