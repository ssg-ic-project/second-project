package com.ssg.secondproject.domain;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Outbound {
    private int id;
    private int productId;
//    private int productName;
    private int cellId;
    private LocalDate expectedDate;
    private int quantity;
    private Long remarks;
    private boolean isDispatch;
    private boolean isInvoice;
    private int userId;
//    private String userName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
//    private String approvalStatus;

}
