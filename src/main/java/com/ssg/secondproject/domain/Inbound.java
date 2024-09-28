package com.ssg.secondproject.domain;

import java.time.LocalDateTime;
import java.util.Date;
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
public class Inbound extends BaseInfo {
    private int productId;
    private int cellId;
    private Date expectedDate;
    private int quantity;
    private String comment;
    private int userId;
}
