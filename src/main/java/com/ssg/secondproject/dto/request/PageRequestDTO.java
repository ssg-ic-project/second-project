package com.ssg.secondproject.dto.request;

import com.ssg.secondproject.common.SearchType;
import com.ssg.secondproject.dto.SearchTypeDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    private int size = 10;

    @Builder.Default
    private String orderBy = "id";

    @Builder.Default
    private String orderByDir = "DESC";

    /**
     * @ModelAttribute 사용 시 search 필드에 데이터가 담기지 않는 현상이 발생하고 있습니다.
     * 현재 SearchTypeDTO 대신 Map<SearchType, String>으로 대체하거나 다른 방법을 탐색 중입니다.
     * 현상을 확인한 후 리팩토링 예정입니다.
     */

    private SearchTypeDTO search = new SearchTypeDTO();

//    @Builder.Default
//    private Map<String, String> search = new HashMap<>();

//    private String S;  // status
//    private String N; // name, company name
//    private String E; // email
//    private String R; // role
//    private Integer WH;  // warehouse
//    private String SD;  // start date
//    private String ED;  // end date


    public int getOffset() {
        return (page - 1) * 10;
    }

}
