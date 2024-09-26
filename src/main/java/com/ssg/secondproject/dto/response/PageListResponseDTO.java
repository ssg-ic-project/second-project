package com.ssg.secondproject.dto.response;

import com.ssg.secondproject.dto.PageInfoDTO;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageListResponseDTO<T> {

    private PageInfoDTO pageInfoDTO;
    private List<T> dataList;

}
