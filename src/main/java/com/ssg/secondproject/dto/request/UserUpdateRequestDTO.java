package com.ssg.secondproject.dto.request;

import com.ssg.secondproject.common.Status;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDTO {

    private String businessNumber;
    private Status status;

    @Builder.Default
    private LocalDateTime updatedAtt = LocalDateTime.now();
}
