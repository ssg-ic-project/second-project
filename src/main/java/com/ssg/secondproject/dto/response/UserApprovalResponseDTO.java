package com.ssg.secondproject.dto.response;

import com.ssg.secondproject.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.executor.statement.StatementUtil;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserApprovalResponseDTO {
    private Status status;
    private String rejectionReason;
    private String createdAt;
}
