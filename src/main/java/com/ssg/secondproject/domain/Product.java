package com.ssg.secondproject.domain;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String code;

    private Double height;

    private Double width;

    private Double depth;

    private String manufacturer;

    private Double actualPrice;

    private Double salePrice;

    private Integer userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
