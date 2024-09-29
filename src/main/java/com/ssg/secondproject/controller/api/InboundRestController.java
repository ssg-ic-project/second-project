package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.SearchTypeDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.InboundDetailResponseDTO;
import com.ssg.secondproject.dto.response.InboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.service.InboundService;
import java.nio.charset.Charset;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String orderBy,
        @RequestParam String orderByDir,
        @RequestParam(required = false) String S,
        @RequestParam(required = false) Integer WH) {

        SearchTypeDTO searchTypeDTO = SearchTypeDTO.builder()
            .S(S)
            .WH(WH)
            .build();

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page(page)
            .size(size)
            .orderBy(orderBy)
            .orderByDir(orderByDir)
            .search(searchTypeDTO)
            .build();

        PageListResponseDTO<InboundResponseDTO> data = inboundService.getList(pageRequestDTO);

        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<PageResponseDTO<InboundDetailResponseDTO>> getById(@RequestParam int id) {
        PageResponseDTO<InboundDetailResponseDTO> data = inboundService.getById(id);
        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }
}
