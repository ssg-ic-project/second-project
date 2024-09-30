package com.ssg.secondproject.dto;


import com.ssg.secondproject.domain.BaseInfo;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDTO {

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
