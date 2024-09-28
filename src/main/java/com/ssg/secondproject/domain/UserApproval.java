package com.ssg.secondproject.domain;

import com.ssg.secondproject.common.Status;
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
public class UserApproval extends BaseInfo {
    private int userId;
    private int approverId;
    private Status status;
    private String rejectionReason;
}
