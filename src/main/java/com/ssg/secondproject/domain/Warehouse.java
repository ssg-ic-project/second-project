package com.ssg.secondproject.domain;

import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {

    private Integer id;

    private Integer adminId;

    private String name;

    private Integer size;

    private Integer capacity;

    private Double latitude;

    private Double longitude;

    private String address;

    private LocalDateTime createdAt;

    private Integer updatedId;

    private LocalDateTime updatedAt;
}
