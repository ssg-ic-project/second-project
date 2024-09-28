package com.ssg.secondproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutboundRequestDTO {
    private int outboundId;
    private String status;
    private LocalDate createdAt;
    private Long rejectReason;
}
