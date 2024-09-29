package com.ssg.secondproject.dto.request;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutboundApprovalRequestDTO {
    private int outboundId;
    private String status;
    private int approverId;

    @Builder.Default
    private String rejectionReason = "";

    @Builder.Default
    private LocalDate createdAt = LocalDate.now();

    }

