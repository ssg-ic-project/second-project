package com.ssg.secondproject.dto.request;

import com.ssg.secondproject.common.Status;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InboundApprovalRequestDTO {
    private int inboundId;
    private Status status;

    @Builder.Default
    private String rejectionReason = "";

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
