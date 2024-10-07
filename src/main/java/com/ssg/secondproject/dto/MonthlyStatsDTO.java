package com.ssg.secondproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyStatsDTO {
    private int newUsers;    // 신규 가입자 수
    private int newInboundRequests;  // 신규 입고 요청 수
    private int newOutboundRequests; // 신규 출고 요청 수
}
