package com.ssg.secondproject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssg.secondproject.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponseDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String businessNumber;
    private String companyName;
    private Status status;
    private String zipCode;
    private String address;
    private String comment;

    @JsonProperty("isUnregister")
    private boolean isUnregister;
    private String unregisterReason;
    private String createdAt;
    private String updatedAt;
    private String unregisteredAt;
}
