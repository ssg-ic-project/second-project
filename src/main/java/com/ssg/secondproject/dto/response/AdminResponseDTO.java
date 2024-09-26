package com.ssg.secondproject.dto.response;

import com.ssg.secondproject.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponseDTO {
    private int id;
    private String name;
    private String username;
    private String companyEmail;
    private int warehouseId;
    private String warehouseName;
    private Role role;
    private String phone;
    private String createdAt;
    private String updatedAt;
}
