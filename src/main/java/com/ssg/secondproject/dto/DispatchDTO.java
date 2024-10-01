package com.ssg.secondproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//사용자에게 받는 배차 등록 선택하는 값. allocationSpace는 vehicleType으로 정해짐
public class DispatchDTO {

    private int outboundId;
    private int vehicleId;
    private String vehicleType;

    @Builder.Default
    private double allocation = 0;

    @Builder.Default
    private long remark = ' ';

    @Builder.Default
    private String status = "PENDING";

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
