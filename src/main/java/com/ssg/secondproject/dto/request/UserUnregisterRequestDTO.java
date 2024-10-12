package com.ssg.secondproject.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssg.secondproject.common.Status;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserUnregisterRequestDTO {
    private int id;

    @JsonProperty("isUnregister")
    private boolean isUnregister;

    private String unregisterReason;

    @Builder.Default
    private LocalDateTime unregisteredAt = LocalDateTime.now();

    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}
