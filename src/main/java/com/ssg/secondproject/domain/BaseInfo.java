package com.ssg.secondproject.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseInfo {
    private int id;
    private int createdId;
    private String createdAt;
    private int updatedId;
    private String updatedAt;
    private String unregisteredAt;

}