package com.ssg.secondproject.controller.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api/admin")
public class AdminRestController {

    @GetMapping("/list")
    public String getAdminList() {
        log.info(" 🎉🎉🎉🎉 Rest Admin List 🎉🎉🎉🎉 ");
        return """
            {
                "status": "success",
                "data": {
                     "adminList": [
                        {
                          "id": 1,
                          "name": "신짱구",
                          "role": "총관리자",
                          "department": "개발팀",
                          "position": "총괄팀장",
                          "email": "jjanggu@3pl.co.kr"
                        },
                        {
                          "id": 2,
                          "name": "한유리",
                          "role": "직원",
                          "department": "회계팀",
                          "position": "팀원",
                          "email": "yuri@3pl.co.kr"
                        },
                        {
                          "id": 3,
                          "name": "이훈이",
                          "role": "관리자",
                          "department": "창고팀",
                          "position": "팀장",
                          "email": "hooni@3pl.co.kr"
                        },
                        {
                          "id": 4,
                          "name": "이맹구",
                          "role": "직원",
                          "department": "인사팀",
                          "position": "팀원",
                          "email": "maenggu@3pl.co.kr"
                        },
                        {
                          "id": 5,
                          "name": "김철수",
                          "role": "관리자",
                          "department": "배송팀",
                          "position": "팀장",
                          "email": "cheolsoo@3pl.co.kr"
                        },
                        {
                          "id": 6,
                          "name": "신짱구",
                          "role": "총관리자",
                          "department": "개발팀",
                          "position": "총괄팀장",
                          "email": "jjanggu@3pl.co.kr"
                        },
                        {
                          "id": 7,
                          "name": "한유리",
                          "role": "직원",
                          "department": "회계팀",
                          "position": "팀원",
                          "email": "yuri@3pl.co.kr"
                        },
                        {
                          "id": 8,
                          "name": "이훈이",
                          "role": "관리자",
                          "department": "창고팀",
                          "position": "팀장",
                          "email": "hooni@3pl.co.kr"
                        },
                        {
                          "id": 9,
                          "name": "이맹구",
                          "role": "직원",
                          "department": "인사팀",
                          "position": "팀원",
                          "email": "maenggu@3pl.co.kr"
                        },
                        {
                          "id": 10,
                          "name": "김철수",
                          "role": "관리자",
                          "department": "배송팀",
                          "position": "팀장",
                          "email": "cheolsoo@3pl.co.kr"
                        }
                    ]
                }
            }
            """;
    }

    @GetMapping()
    public String getAdmin(@RequestParam int id) {
        log.info(" 🎉🎉🎉🎉 Rest Admin Detail 🎉🎉🎉🎉\n ID:  " + id);
        return """
            {
                "status": "success",
                "data": {
                     "admin": {
                          "id": 1,
                          "name": "신짱구",
                          "adminId" : "jjanggu",
                          "email": "jjanggu@3pl.co.kr",
                          "role": "총관리자",
                          "department": "개발팀",
                          "position": "총괄팀장",
                          "phone": "010-2734-5912",
                          "createdAt": "2022-09-15 12:30:45",
                          "updatedAt": "2022-09-30 09:25:12"
                        }
                }
            }
            """;
    }
}
