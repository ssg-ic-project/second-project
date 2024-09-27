package com.ssg.secondproject.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseUpdateDTO {

    private int adminId;

    private String name;

    private int size;

    private int capacity;

    private double latitude;

    private double longitude;

    private String address;
}
