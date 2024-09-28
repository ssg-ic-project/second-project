package com.ssg.secondproject.dto.response;

import com.ssg.secondproject.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalResponseDTO {
    private String status;
    private String rejectionReason;
    private String createdAt;
}
