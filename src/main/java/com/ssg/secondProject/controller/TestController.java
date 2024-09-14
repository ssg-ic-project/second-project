package com.ssg.secondProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/fragments") // 이 클래스의 모든 메서드는 "/admin" URL을 기본 경로로 가집니다.
public class TestController {

    @GetMapping("/header") // "/admin/index" URL로 GET 요청이 들어오면 이 메서드가 실행됩니다.
    public String index() {
        return "fragments/header"; // resources/templates/admin/index.html 파일을 반환합니다.
    }
}