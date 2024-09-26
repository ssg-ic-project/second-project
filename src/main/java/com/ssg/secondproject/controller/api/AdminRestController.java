package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.AdminResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
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

    private final AdminService adminService;

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return httpHeaders;
    }

    @GetMapping("/list")
    public ResponseEntity<PageListResponseDTO<AdminResponseDTO>> getAdminList(PageRequestDTO pageRequestDTO, BindingResult bindingResult) {
        log.info(" 🎉🎉🎉🎉 Rest Admin List 🎉🎉🎉🎉 ");
//
        PageListResponseDTO<AdminResponseDTO> data =  adminService.getList(pageRequestDTO);

        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<PageResponseDTO<AdminResponseDTO>> getAdmin(@RequestParam int id) {
        log.info(" 🎉🎉🎉🎉 Rest Admin Detail 🎉🎉🎉🎉\n ID:  " + id);

        PageResponseDTO<AdminResponseDTO> data = adminService.getById(id);

        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }
}
