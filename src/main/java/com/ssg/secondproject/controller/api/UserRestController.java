package com.ssg.secondproject.controller.api;

import com.ssg.secondproject.dto.SearchTypeDTO;
import com.ssg.secondproject.dto.request.PageRequestDTO;
import com.ssg.secondproject.dto.response.ApprovalResponseDTO;
import com.ssg.secondproject.dto.response.PageListResponseDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.dto.response.UserDetailResponseDTO;
import com.ssg.secondproject.dto.response.UserResponseDTO;
import com.ssg.secondproject.service.UserService;
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
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return httpHeaders;
    }

    @GetMapping("/list")
    public ResponseEntity<PageListResponseDTO<UserResponseDTO>> getUserList(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String orderBy,
        @RequestParam String orderByDir,
        @RequestParam(required = false) String S,
        @RequestParam(required = false) String N,
        @RequestParam(required = false) String E) {

        SearchTypeDTO searchTypeDTO = SearchTypeDTO.builder()
            .S(S)
            .N(N)
            .E(E)
            .build();

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page(page)
            .size(size)
            .orderBy(orderBy)
            .orderByDir(orderByDir)
            .search(searchTypeDTO)
            .build();

        PageListResponseDTO<UserResponseDTO> data = userService.getList(pageRequestDTO);

        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<PageResponseDTO<UserDetailResponseDTO>> getById(@RequestParam int id) {
        PageResponseDTO<UserDetailResponseDTO> data = userService.getById(id);

        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/approval/list")
    public ResponseEntity<PageListResponseDTO<ApprovalResponseDTO>> getApprovalByUserId(@RequestParam int userId) {
        PageListResponseDTO<ApprovalResponseDTO> data = userService.getApprovalByUserId(userId);

        return new ResponseEntity<>(data, getHttpHeaders(), HttpStatus.OK);
    }
}
