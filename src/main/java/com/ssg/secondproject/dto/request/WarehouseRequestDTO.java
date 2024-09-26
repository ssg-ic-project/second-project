package com.ssg.secondproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseRequestDTO {

    @NotNull(message = "관리자 ID는 필수입니다.")
    private Integer adminId;

    @NotBlank
    private String name;

    @NotNull
    private int size;

    @NotNull
    private int capacity;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotBlank
    private String address;
}
