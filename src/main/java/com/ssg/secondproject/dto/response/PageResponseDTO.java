package com.ssg.secondproject.dto.response;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PageResponseDTO<T> {
    private int page;
    private int size;
    private int total;

    private int start;
    private int end;

    private boolean prev;
    private boolean next;

    private List<T> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<T> dtoList, int total) {
        if (total <= 0) {
            return;
        }

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9;

        int last = (int) (Math.ceil((total/(double)size)));
        this.end = end > last ? last : end;

        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}