package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.UserResponseDTO;
import com.ssg.secondproject.service.UserService;
import java.nio.charset.Charset;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return httpHeaders;
    }

    @GetMapping("/list")
    public ResponseEntity<PageListResponseDTO<UserResponseDTO>> getUserList(
        PageRequestDTO pageRequestDTO, BindingResult bindingResult) {
        log.info(" 🎉🎉🎉🎉 Rest User List 🎉🎉🎉🎉 ");

        log.info("pageRequestDTO : " + pageRequestDTO);

        PageListResponseDTO<UserResponseDTO> data = userService.getList(pageRequestDTO);

        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
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
