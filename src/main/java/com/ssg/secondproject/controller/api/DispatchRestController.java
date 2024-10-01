package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.DispatchDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.service.DispatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/outbound")
public class DispatchRestController {

    private final DispatchService dispatchService;

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return httpHeaders;
    }

    //배차 등록. 배차 란을 누르면 Id 값이 파라미터로 전달되어야 한다.
    @GetMapping("/dispatch")
    public ResponseEntity<PageResponseDTO<DispatchDTO>> getDispatch(@RequestParam int id) {
        PageResponseDTO<DispatchDTO> data = dispatchService.getById(id);
        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }

    //출고ID도 같이 전달되어야 한다.
    @PostMapping("/register")
//    public ResponseEntity<Void> updateDispatch(@ModelAttribute DispatchDTO dispatchDTO){
//        dispatchService.update(dispatchDTO);
    public ResponseEntity<Void> insertDispatch(@RequestParam("outboundId") int outboundId,  @RequestParam("vehicleId") int vehicleId, @RequestParam("vehicleType") String vehicleType){
        int approvalId = 5;
        dispatchService.insert(approvalId, outboundId, vehicleId, vehicleType);
        return new ResponseEntity(getHttpHeaders(), HttpStatus.OK);
    }
    public ResponseEntity<Void> updateDispatch(@RequestParam("outboundId") int outboundId,  @RequestParam("vehicleId") int vehicleId, @RequestParam("vehicleType") String vehicleType){
//        dispatchService.update(outboundId, vehicleId, vehicleType);
        return new ResponseEntity(getHttpHeaders(), HttpStatus.OK);
    }
}