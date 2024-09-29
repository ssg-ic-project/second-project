package com.ssg.secondproject.controller.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/inbound/approval")
public class InboundApprovalRestController {

    @PostMapping("/process")
    public ResponseEntity<Void> processApproval() {

        return new ResponseEntity(HttpStatus.OK);
    }
}
