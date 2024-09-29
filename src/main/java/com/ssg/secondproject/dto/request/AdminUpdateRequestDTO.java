package com.ssg.secondproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminUpdateRequestDTO {

    private int updatedId;
    private AdminRequestDTO requestDTO;

}
