package com.ssg.secondproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
    private Integer id;

    private Integer adminId;

    private String name;

    private int size;

    private int capacity;

    private double latitude;

    private double longitude;

    private String address;

    private LocalDateTime createdAt;

//    최종 수정자 id;
    private Integer modAdminId;

    private LocalDateTime updatedAt;
}
