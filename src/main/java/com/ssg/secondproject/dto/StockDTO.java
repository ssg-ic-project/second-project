package com.ssg.secondproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;


//	`id`	int unsigned	NOT NULL	COMMENT 'AUTO_INCREMENT',
//    `product_id` int unsigned not NULL,
//    `cell_id` int unsigned not NULL,
//	`quantity`	int unsigned	NOT NULL,
//	`actual_quantity`	int unsigned	NULL,
//    `remarks` longtext null,
//	`created_at`	datetime	NOT NULL,
//	`updated_at`	datetime	NULL

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private Integer id;

    private Integer productId;

    private Integer cellId;

    private int quantity;

    private int actualQuantity;

    private String remarks;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
