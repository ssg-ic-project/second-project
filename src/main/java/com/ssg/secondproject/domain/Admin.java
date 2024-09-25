package com.ssg.secondproject.domain;

import com.ssg.secondproject.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BaseInfo {
    private String name;
    private String username;
    private String password;
    private String salt;
    private String companyEmail;
    private Role role;
    private String phone;
}
