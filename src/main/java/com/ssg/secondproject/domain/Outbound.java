package com.ssg.secondproject.domain;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Outbound {
    private Integer id;
    private Integer productId;
    private Integer cellId;
    private LocalDate expectedDate;
    private int quantity;
    private Long remarks;
    private boolean isDispatch;
    private boolean isInvoice;
    private Integer userId;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
