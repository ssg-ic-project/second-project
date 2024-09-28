package com.ssg.secondproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InboundDetailResponseDTO {

    private int inboundId;
    private String expectedDate;
    private int quantity;
    private String createdAt;
    private String updatedAt;
    private int warehouseId;
    private String warehouseName;
    private String sectionName;
    private String cellName;
    private int stockQuantity;
    private int productId;
    private String productName;
    private String mainCategory;
    private String subCategory;
    private String detailCategory;
    private int height;
    private int width;
    private int depth;
    private int userId;
    private String userName;
    private String companyName;
    private String email;
    private String phone;
}
