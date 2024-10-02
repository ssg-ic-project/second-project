package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.SearchTypeDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.*;
import com.ssg.secondproject.service.OutboundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/outbound")
public class OutboundRestController {
    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return httpHeaders;
    }

    private final OutboundService outboundService;

//    그냥 list 가지고 오는 부분
//    @GetMapping("/list")
//    public ResponseEntity<PageListResponseDTO<OutboundResponseDTO>> getOutboundList(
//        PageRequestDTO pageRequestDTO, BindingResult bindingResult){
//        PageListResponseDTO<OutboundResponseDTO> data = outboundService.getList(pageRequestDTO);
//        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
//    }

    // 출고 테이블의 ID 클릭시 상세페이지로 이동
    @GetMapping()
    public ResponseEntity<PageResponseDTO<OutboundDetailResponseDTO>> getOutbound(@RequestParam int id) {
        log.info("GetOutbound controller is running. Getting one outbound id");
        PageResponseDTO<OutboundDetailResponseDTO> data = outboundService.getById(id);
        log.info(data.getData());
        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }

    //같은 상세 페이지에서 fetch는 detail 페이지 들어갈때 같이 호출하면 됨.
    @GetMapping("/log")
    public ResponseEntity<Map<String, Object>> getOutboundLog(@RequestParam int id) {
        // Get OutboundApproval history
        PageResponseDTO<ApprovalResponseDTO> outboundLog = outboundService.getByIdLog(id);
        // Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("outboundLog", outboundLog);
        return ResponseEntity.ok(response);
    }

//    출고 조회 첫 페이지로 생각해도 무방하다. where 문으로 입력값에 대한 결과를 반환하기 때문엘 값이 없어도 무방하다.
//    @GetMapping("/searchby")
//    public ResponseEntity<PageListResponseDTO<OutboundDetailResponseDTO>> getUserInput(PageRequestDTO pageRequestDTO, @RequestParam("warehouseName") String warehouseName, @RequestParam("approvalStatus") String approvalStatus,
//                                                                                       @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
//        PageListResponseDTO<OutboundDetailResponseDTO> data = outboundService.getByUserInput(pageRequestDTO, warehouseName, approvalStatus, startDate, endDate);
//        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
//    }

    @GetMapping("/list")
    public ResponseEntity<PageListResponseDTO<OutboundResponseDTO>> getList(
            // @ModelAttribute PageRequestDTO pageRequestDTO) {
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String orderBy,
            @RequestParam String orderByDir,
            @RequestParam(required = false) String S,
            @RequestParam(required = false) Integer WH,
            @RequestParam(required = false) String SD,
            @RequestParam(required = false) String ED,
            @RequestParam(required = false) String OS,
            @RequestParam(required = false) String DS) {

        SearchTypeDTO searchTypeDTO = SearchTypeDTO.builder()
                .S(S)
                .WH(WH)
                .SD(SD)
                .ED(ED)
                .OS(OS)
                .DS(DS)
                .build();

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(page)
                .size(size)
                .orderBy(orderBy)
                .orderByDir(orderByDir)
                .search(searchTypeDTO)
                .build();

        PageListResponseDTO<OutboundResponseDTO> data = outboundService.getList(pageRequestDTO);
        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }
}