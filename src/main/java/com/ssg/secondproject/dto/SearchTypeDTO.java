package com.ssg.secondproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchTypeDTO {

    private String S;  // status
    private String N; // name, company name
    private String E; // email
    private Integer WH;  // warehouse
    private String SD;  // start date
    private String ED;  // end date
}
