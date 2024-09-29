package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.OutboundApprovalRequestDTO;
import com.ssg.secondproject.service.OutboundApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/outbound/approval")
public class OutboundApprovalRestController {

    private final OutboundApprovalService outboundApprovalService;

    //출고 승인 후 승인된 출고에 대해서 OutboundApprovalRequestDTO로 매핑한 것을 가지고 활용하면 됨.
    //security 써서 사용자 아이디 가지고 올 수 있음.
    @PostMapping("/status")
    public ResponseEntity<Void> approveOutbound(@RequestBody OutboundApprovalRequestDTO requestDTO){
        int approverId = 6;
        outboundApprovalService.approveOutbound(approverId, requestDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    //출고 완료 재고 log 추가
    //배송 상태 update후 trigger로
    @PostMapping("/complete")
    public ResponseEntity<Void> completeOutbound(@RequestBody OutboundApprovalRequestDTO requestDTO){
        int approverId = 6;
        outboundApprovalService.completeOutbound(approverId, requestDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
