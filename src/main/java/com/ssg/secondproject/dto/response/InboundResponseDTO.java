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
public class InboundResponseDTO {
    private int id;
    private int userId;
    private String userName;
    private int productId;
    private String productName;
    private int cellId;
    private String expectedDate;
    private int quantity;
    private Status status;
    private String approvedAt;
}
