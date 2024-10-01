package com.ssg.secondproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutboundResponseDTO {
    private int id;
    private String productName;
    private int quantity;
    private String companyName;
    private boolean isDispatch;
    private boolean isInvoice;
    private String approvalStatus;
}
