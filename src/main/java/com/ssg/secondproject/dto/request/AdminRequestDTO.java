package com.ssg.secondproject.dto.request;

import com.ssg.secondproject.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequestDTO {
    private int id;
    private String name;
    private String username;
    private String password;
    private int warehouseId;
    private Role role;
    private String phone;
    private String updatedAt;

}
