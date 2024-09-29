package com.ssg.secondproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DispatchResponseDTO {

    private String status;
    private int vehicleId;
    private String vehicleType;
    private double allocation;

}
