package com.ssg.secondproject.controller.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api/user")
public class UserRestController {

    @GetMapping("/list")
    public String getUserList() {
        log.info(" 🎉🎉🎉🎉 Rest User List 🎉🎉🎉🎉 ");
        return """
            {
              "status": "success",
              "data": {
                "userList": [
                  { "id": 1, "name": "신짱구", "companyName": "짱구상사", "email": "jjanggu@company.co.kr", "businessNumber": "123-45-67890", "phone": "010-1234-5678", "isUnregister": 0 },
                  { "id": 2, "name": "한유리", "companyName": "유리상점", "email": "yuri@company.co.kr", "businessNumber": "234-56-78901", "phone": "010-2345-6789", "isUnregister": 1 },
                  { "id": 3, "name": "이훈이", "companyName": "훈이물류", "email": "hooni@company.co.kr", "businessNumber": "345-67-89012", "phone": "010-3456-7890", "isUnregister": 0 },
                  { "id": 4, "name": "이맹구", "companyName": "맹구종합상사", "email": "maenggu@company.co.kr", "businessNumber": "456-78-90123", "phone": "010-4567-8901", "isUnregister": 1 },
                  { "id": 5, "name": "김철수", "companyName": "철수상회", "email": "cheolsoo@company.co.kr", "businessNumber": "567-89-01234", "phone": "010-5678-9012", "isUnregister": 0 },
                  { "id": 6, "name": "신형만", "companyName": "형만카페", "email": "hyungman@company.co.kr", "businessNumber": "678-90-12345", "phone": "010-6789-0123", "isUnregister": 1 },
                  { "id": 7, "name": "봉미선", "companyName": "미선식품", "email": "miseon@company.co.kr", "businessNumber": "789-01-23456", "phone": "010-7890-1234", "isUnregister": 0 },
                  { "id": 8, "name": "신짱아", "companyName": "짱아건설", "email": "jjangah@company.co.kr", "businessNumber": "890-12-34567", "phone": "010-8901-2345", "isUnregister": 1 },
                  { "id": 9, "name": "흰둥이", "companyName": "흰둥물산", "email": "hindoong@company.co.kr", "businessNumber": "901-23-45678", "phone": "010-9012-3456", "isUnregister": 0 },
                  { "id": 10, "name": "한수지", "companyName": "수지가구", "email": "suji@company.co.kr", "businessNumber": "012-34-56789", "phone": "010-0123-4567", "isUnregister": 1 }
                ]
              }
            }
            """;
    }

    @GetMapping()
    public String getUser(@RequestParam int id) {
        log.info(" 🎉🎉🎉🎉 Rest User Detail 🎉🎉🎉🎉\n ID:  " + id);
        return """
            {
                "status": "success",
                "data": {
                    "user": {
                        "id": 1,
                        "name": "신짱구",
                        "userId" : "jjanggu",
                        "businessNumber": "123-45-67890",
                        "email": "jjanggu@google.com",
                        "phone": "010-2734-5912",
                        "companyName": "짱구상사",
                        "zipCode": "06166",
                        "address": "서울 강남구 삼성로 534",
                        "isUnregister": 1,
                        "createdAt": "2022-09-15 12:30:45",
                        "updatedAt": "2022-09-30 09:25:12",
                        "unregisterAt": ""
                    },
                    "approvalList" : [
                        { "status": "PENDING", "rejectionReason": "", "createdAt": "2022-09-15 12:30:45"},
                        { "status": "APPROVED", "rejectionReason": "", "createdAt": "2022-09-16 10:14:38"}
                    ]
                }
            }
            """;
    }
}
