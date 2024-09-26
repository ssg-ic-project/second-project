package com.ssg.secondproject.domain;

import java.time.LocalDateTime;
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
public class BaseInfo {
    private int id;
    private int createdId;
    private LocalDateTime createdAt;
    private int updatedId;
    private LocalDateTime updatedAt;
    private LocalDateTime unregisteredAt;
}