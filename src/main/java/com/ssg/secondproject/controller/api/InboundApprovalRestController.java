package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.InboundApprovalRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.service.InboundApprovalService;
import java.nio.charset.Charset;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/inbound/approval")
public class InboundApprovalRestController {

    private final InboundApprovalService inboundApprovalService;

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return httpHeaders;
    }

    @GetMapping("/list")
    public ResponseEntity<PageListResponseDTO<ApprovalResponseDTO>> getApprovalById(@RequestParam int inboundId) {
        PageListResponseDTO<ApprovalResponseDTO> data = inboundApprovalService.getApprovalById(inboundId);
        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }

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
