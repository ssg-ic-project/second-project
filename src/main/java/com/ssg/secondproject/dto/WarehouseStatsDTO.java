package com.ssg.secondproject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseStatsDTO {
private int id;
private int name;
private double useSpace;
private double freeSpace;
}
