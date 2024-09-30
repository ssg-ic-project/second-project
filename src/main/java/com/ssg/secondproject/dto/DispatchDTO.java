package com.ssg.secondproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DispatchDTO {

    private int vehicleId;
    private String vehicleType;
    private double allocation;
    private String status;

}
