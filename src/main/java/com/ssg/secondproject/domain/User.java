package com.ssg.secondproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseInfo {
    private String name;
    private String businessNumber;
    private String email;
    private String phone;
    private String companyName;
    private String username;
    private String password;
    private String salt;
    private String zipCode;
    private String address;
    private String comment;
    private boolean isUnregister;
}
