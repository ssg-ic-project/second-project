package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.InboundApprovalRequestDTO;
import com.ssg.secondproject.service.InboundApprovalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/inbound/approval")
public class InboundApprovalRestController {

    private final InboundApprovalService inboundApprovalService;

    @PostMapping("/status")
    public ResponseEntity<Void> createApprovalStatus(@RequestBody InboundApprovalRequestDTO requestDTO) {
        int approverId = 4; // 임시 직원 ID

        inboundApprovalService.createApprovalStatus(approverId, requestDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> processCompleteApproval(@RequestBody InboundApprovalRequestDTO requestDTO) {
        int approverId = 4; // 임시 직원 ID

        inboundApprovalService.processCompleteApproval(approverId, requestDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
