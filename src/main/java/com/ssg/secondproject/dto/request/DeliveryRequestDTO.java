package com.ssg.secondproject.dto.request;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequestDTO {
    private int outboundId;
    @Builder.Default
    private String status = "PENDING";

    @Builder.Default
    private LocalDate startDate = null;
    private LocalDateTime toArrive = null;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}
