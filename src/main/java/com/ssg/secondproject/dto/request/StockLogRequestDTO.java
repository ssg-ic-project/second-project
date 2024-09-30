package com.ssg.secondproject.dto.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StockLogRequestDTO {

    @Builder.Default
    private Integer inboundId = null;

    @Builder.Default
    private Integer outboundId = null;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}
