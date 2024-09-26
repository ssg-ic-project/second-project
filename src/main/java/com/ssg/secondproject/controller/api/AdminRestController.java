package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.service.AdminService;
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
@RequestMapping("/api/admin")
public class AdminRestController {

    private HttpHeaders httpHeaders = new HttpHeaders();
    private final AdminService adminService;

    @GetMapping("/list")
    public ResponseEntity<PageListResponseDTO<AdminResponseDTO>> getAdminList(PageRequestDTO pageRequestDTO, BindingResult bindingResult) {
        log.info(" 🎉🎉🎉🎉 Rest Admin List 🎉🎉🎉🎉 ");
        PageListResponseDTO<AdminResponseDTO> data =  adminService.getList(pageRequestDTO);
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(data, httpHeaders, HttpStatus.OK);
//        return new ResponseEntity<>(message, httpHeaders, HttpStatus.OK);
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
