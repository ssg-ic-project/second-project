package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.SearchTypeDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.InboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.service.InboundService;
import java.nio.charset.Charset;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/inbound")
public class InboundRestController {

    private final InboundService inboundService;

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return httpHeaders;
    }

    @GetMapping("/list")
    public ResponseEntity<PageListResponseDTO<InboundResponseDTO>> getInboundList(
        @ModelAttribute PageRequestDTO pageRequestDTO) {
        PageListResponseDTO<InboundResponseDTO> data = inboundService.getList(pageRequestDTO);
        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }

    @GetMapping()
    public String getInbound(@RequestParam int id) {
        log.info(" 🎉🎉🎉🎉 Rest Inbound Detail 🎉🎉🎉🎉\n ID:  " + id);
        return """
            {
                "status": "success",
                "data": {
                    "inbound": {
                        "id": 10,
                        "expectedDate": "2024-09-20",
                        "quantity": 50,
                        "createdAt": "2024-08-24 11:28:13",
                        "updatedAt": "2024-08-24 11:28:13",
                        "userId": 23,
                        "userName": "둘리",
                        "companyName": "호이호이",
                        "userEmail": "hoi0922@gmail.com",
                        "userPhone": "010-2784-3978",
                        "warehouseId": 6,
                        "warehouseName": "의정부 창고",
                        "sectionName": "B",
                        "cellName": "B2",
                        "stock": 148,
                        "productId": 52,
                        "productName": "구름 침대",
                        "mainCategory": "침대",
                        "subCategory": "퀸 침대",
                        "detailCategory": "매트리스",
                        "productHeight": 350,
                        "productWidth": 1500,
                        "productDepth": 2000
                    },
                    "approvalList" : [
                        { "status": "PENDING", "rejectionReason": "", "createdAt": "2024-08-24 11:28:13"},
                        { "status": "APPROVED", "rejectionReason": "", "createdAt": "2024-08-25 09:12:25"}
                    ]
                }
            }
            """;
    }
}
