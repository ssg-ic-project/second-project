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

    private int id;

    private int adminId;

    private String name;

    private int size;

    private int capacity;

    private double latitude;

    private double longitude;

    private String address;

    private LocalDateTime createdAt;

    private int updatedId;

    private LocalDateTime updatedAt;
}
