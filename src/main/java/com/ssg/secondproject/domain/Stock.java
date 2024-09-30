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
public class Stock {
    private Integer id;

    private Integer productId;

    private Integer cellId;

    private Integer quantity;

    private Integer actualQuantity;

    private String remarks;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Product product;
}
