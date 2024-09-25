package com.ssg.secondproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Pageable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO { //paging관련 정보(page/size, 검색 종류(type), 키워드) 저장 용도
    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    private String type; //검색 종류: t,c,tc,tw,twc
    private String keyword;

    private String orderBy;
    private String orderByDir;

    public int getOffset() {
        return (page - 1) * size;
    }
}
