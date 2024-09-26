package com.ssg.secondproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    private String keyword;

    @Builder.Default
    private String orderBy = "id";

    @Builder.Default
    private String orderByDir = "DESC";

    public int getOffset() {
        return (page - 1) * size;
    }
}
