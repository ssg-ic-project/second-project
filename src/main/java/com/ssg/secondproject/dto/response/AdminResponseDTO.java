package com.ssg.secondproject.dto.response;

import com.ssg.secondproject.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponseDTO {
    private int id;
    private String name;
    private String companyEmail;
    private Role role;
    private String phone;
    private int warehouseId;
    private String createdAt;
}
