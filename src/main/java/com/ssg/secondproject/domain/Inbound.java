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
    private int product_id;
    private int cell_id;
    private Date expected_date;
    private int quantity;
    private String comment;
    private int user_id;
}
