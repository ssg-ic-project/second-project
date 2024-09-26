package com.ssg.secondproject.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutboundResponseDTO {
    private int id;
    private int productId;
    private String productName;
    private int cellId;
    private LocalDate expectedDate;
    private int quantity;
    private Long remarks;
    private boolean isDispatch;
    private boolean isInvoice;
    private int userId;
    private String userName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String approvalStatus;
}
