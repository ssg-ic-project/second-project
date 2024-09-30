package com.ssg.secondproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockLog {
    private Integer id;

    private Integer stockId;

    private Integer inboundId;

    private Integer outboundId;

    private Integer quantity;

    private LocalDateTime createdAt;
}
