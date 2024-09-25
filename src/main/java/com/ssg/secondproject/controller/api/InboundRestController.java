package com.ssg.secondproject.controller.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api/inbound")
public class InboundRestController {

    @GetMapping("/list")
    public String getInboundList() {
        log.info(" 🎉🎉🎉🎉 Rest Inbound List 🎉🎉🎉🎉 ");
        return """
            {
                "status": "success",
                "data": {
                    "inboundList": [
                        {
                          "id": 10,
                          "userId": 23,
                          "userName": "신짱구",
                          "productId": 52,
                          "productName": "에버우드 클래식 침대",
                          "cellId": 3,
                          "expectedDate": "2024-09-20",
                          "quantity": 50,
                          "approvalStatus": "PENDING",
                          "createdAt": "2024-09-15 12:30:00"
                        },
                        {
                          "id": 9,
                          "userId": 44,
                          "userName": "한유리",
                          "productId": 31,
                          "productName": "모던 루나 소파",
                          "cellId": 5,
                          "expectedDate": "2024-09-21",
                          "quantity": 30,
                          "approvalStatus": "APPROVED",
                          "createdAt": "2024-09-14 09:45:00"
                        },
                        {
                          "id": 8,
                          "userId": 13,
                          "userName": "이훈이",
                          "productId": 25,
                          "productName": "코지 홈 원목 식탁",
                          "cellId": 8,
                          "expectedDate": "2024-09-22",
                          "quantity": 70,
                          "approvalStatus": "REJECTED",
                          "createdAt": "2024-09-13 10:15:00"
                        },
                        {
                          "id": 7,
                          "userId": 56,
                          "userName": "이맹구",
                          "productId": 14,
                          "productName": "헤리티지 빈티지 의자",
                          "cellId": 6,
                          "expectedDate": "2024-09-23",
                          "quantity": 40,
                          "approvalStatus": "PENDING",
                          "createdAt": "2024-09-12 14:20:00"
                        },
                        {
                          "id": 6,
                          "userId": 15,
                          "userName": "김철수",
                          "productId": 61,
                          "productName": "스칸디나비아 스타일 선반",
                          "cellId": 2,
                          "expectedDate": "2024-09-24",
                          "quantity": 25,
                          "approvalStatus": "APPROVED",
                          "createdAt": "2024-09-11 16:35:00"
                        },
                        {
                          "id": 5,
                          "userId": 37,
                          "userName": "신형만",
                          "productId": 17,
                          "productName": "릴랙스 리클라이너 체어",
                          "cellId": 9,
                          "expectedDate": "2024-09-25",
                          "quantity": 55,
                          "approvalStatus": "REJECTED",
                          "createdAt": "2024-09-10 18:50:00"
                        },
                        {
                          "id": 4,
                          "userId": 46,
                          "userName": "봉미선",
                          "productId": 28,
                          "productName": "에코 파인 우드 서랍장",
                          "cellId": 4,
                          "expectedDate": "2024-09-26",
                          "quantity": 35,
                          "approvalStatus": "PENDING",
                          "createdAt": "2024-09-09 08:20:00"
                        },
                        {
                          "id": 3,
                          "userId": 19,
                          "userName": "신짱아",
                          "productId": 72,
                          "productName": "시그니처 라운드 테이블",
                          "cellId": 10,
                          "expectedDate": "2024-09-27",
                          "quantity": 85,
                          "approvalStatus": "APPROVED",
                          "createdAt": "2024-09-08 12:45:00"
                        },
                        {
                          "id": 2,
                          "userId": 29,
                          "userName": "흰둥이",
                          "productId": 39,
                          "productName": "컴포트 플러스 라운지 체어",
                          "cellId": 7,
                          "expectedDate": "2024-09-28",
                          "quantity": 95,
                          "approvalStatus": "REJECTED",
                          "createdAt": "2024-09-07 10:10:00"
                        },
                        {
                          "id": 1,
                          "userId": 1,
                          "userName": "한수지",
                          "productId": 11,
                          "productName": "엘레강트 글로리 드레스룸",
                          "cellId": 12,
                          "expectedDate": "2024-09-29",
                          "quantity": 120,
                          "approvalStatus": "PENDING",
                          "createdAt": "2024-09-06 11:05:00"
                        }
                    ]
                }
            }
            """;
    }

    @GetMapping()
    public String getInbound(@RequestParam int id) {
        log.info(" 🎉🎉🎉🎉 Rest Inbound Detail 🎉🎉🎉🎉\n ID:  " + id);
        return """
            {
                "status": "success",
                "data": {
                    "inbound": {
                        "id": 10,
                        "expectedDate": "2024-09-20",
                        "quantity": 50,
                        "createdAt": "2024-08-24 11:28:13",
                        "updatedAt": "2024-08-24 11:28:13",
                        "userId": 23,
                        "userName": "둘리",
                        "companyName": "호이호이",
                        "userEmail": "hoi0922@gmail.com",
                        "userPhone": "010-2784-3978",
                        "warehouseId": 6,
                        "warehouseName": "의정부 창고",
                        "sectionName": "B",
                        "cellName": "B2",
                        "stock": 148,
                        "productId": 52,
                        "productName": "구름 침대",
                        "mainCategory": "침대",
                        "subCategory": "퀸 침대",
                        "detailCategory": "매트리스",
                        "productHeight": 350,
                        "productWidth": 1500,
                        "productDepth": 2000
                    },
                    "approvalList" : [
                        { "status": "PENDING", "rejectionReason": "", "createdAt": "2024-08-24 11:28:13"},
                        { "status": "APPROVED", "rejectionReason": "", "createdAt": "2024-08-25 09:12:25"}
                    ]
                }
            }
            """;
    }
}
