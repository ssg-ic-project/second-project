package com.ssg.secondproject.dto;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageInfoDTO {
    private int page;
    private int size;
    private int total;

    private int start;
    private int end;

    private boolean prev;
    private boolean next;

    @Builder(builderMethodName = "withAll")
    public PageInfoDTO(PageRequestDTO pageRequestDTO, int total) {
        if (total <= 0) {
            return;
        }

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;

        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9;

        int last = (int) (Math.ceil((total/(double)size)));
        this.end = end > last ? last : end;

        this.prev = this.page > this.start;
        this.next = this.page < this.end;
    }
}
