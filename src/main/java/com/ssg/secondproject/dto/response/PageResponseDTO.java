package com.ssg.secondproject.dto.response;

import com.ssg.secondproject.dto.PageInfoDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageResponseDTO<T> {

    private T data;

}
