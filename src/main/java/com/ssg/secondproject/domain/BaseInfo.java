package com.ssg.secondproject.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseInfo {
    private int id;
    private int createdId;
    private LocalDateTime createdAt;
    private int updatedId;
    private LocalDateTime updatedAt;
    private LocalDateTime unregisteredAt;

}