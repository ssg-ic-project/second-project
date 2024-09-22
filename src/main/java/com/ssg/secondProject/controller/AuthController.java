package com.ssg.secondProject.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Log4j2
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/signup")
    public String signup() {
        log.info(" 🎉🎉🎉🎉 Signup 🎉🎉🎉🎉");
        return "auth/signup";
    }

    @GetMapping("/login")
    public String login() {
        log.info(" 🎉🎉🎉🎉 Login 🎉🎉🎉🎉");
        return "auth/login";
    }

    @GetMapping("/find_username")
    public String findUsername() {
        log.info(" 🎉🎉🎉🎉 FindUsername 🎉🎉🎉🎉");
        return "auth/find_username";
    }

    @GetMapping("/reset_password")
    public String resetPassword() {
        log.info(" 🎉🎉🎉🎉 ResetPassword 🎉🎉🎉🎉");
        return "auth/reset_password";
    }
}