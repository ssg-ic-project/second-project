package com.ssg.secondproject.dto.response;

import com.ssg.secondproject.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private int id;
    private String name;
    private String companyName;
    private String email;
    private String businessNumber;
    private String phone;
    private Status status;
}
