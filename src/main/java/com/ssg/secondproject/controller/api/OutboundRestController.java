package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.OutboundResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.service.OutboundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

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


}


