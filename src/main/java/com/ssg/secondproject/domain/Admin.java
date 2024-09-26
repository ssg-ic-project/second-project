package com.ssg.secondproject.domain;

import com.ssg.secondproject.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin extends BaseInfo {
    private String name;
    private String username;
    private String password;
    private String salt;
    private String companyEmail;
    private Role role;
    private String phone;
}
