package com.ssg.secondproject.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutboundDetailResponseDTO { //출고 요청서 상세 페이지 포함
    private int id;
    private LocalDate expectedDate;
    private int quantity;
    private String remarks;
    private boolean isDispatch;
    private boolean isInvoice;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String approvalStatus;
    private int warehouseId;
    private int sectionId;
    private int cellId;
    private String warehouseName;
    private int stockQuantity;
    private LocalDate inboundExpectedDate;
    private int productId;
    private String productName;
    //categoryName 도 포함하기
    private double productHeight;
    private double productWidth;
    private double productDepth;
    private int productCategoryId;
    private int userId;
    private String userName;
    private String companyName;
    private String userBusinessNumber;
    private String userEmail;
    private String userPhone;

}
