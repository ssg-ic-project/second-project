package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.service.OutboundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/outbound")
public class OutboundRestController {
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final OutboundService outboundService;

    @GetMapping("/list")
    public ResponseEntity<PageListResponseDTO<OutboundResponseDTO>> getOutboundList(PageRequestDTO pageRequestDTO, BindingResult bindingResult){
        PageListResponseDTO<OutboundResponseDTO> data = outboundService.getList(pageRequestDTO);
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return new ResponseEntity<>(data, httpHeaders, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<PageResponseDTO<OutboundResponseDTO>> getOutbound(@RequestParam int id){
        log.info("GetOutbound controller is running. Getting one outbound id");
        PageResponseDTO<OutboundResponseDTO> data = outboundService.getById(id);
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return new ResponseEntity<>(data, httpHeaders, HttpStatus.OK);
    }

//    @GetMapping("/log")
//    public ResponseEntity<Map<String, Object>> getOutbound(@RequestParam int id) {
//        // Get OutboundApproval history
//        PageResponseDTO<OutboundResponseDTO> outboundLog = outboundService.getByIdLog(id);
//        // Prepare response
//        Map<String, Object> response = new HashMap<>();
//        response.put("outbound", outboundLog);
//        response.put("outboundLog", outboundLog);
//        return ResponseEntity.ok(response);
//    }
}
