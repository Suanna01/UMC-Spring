package com.umc.umcspring.controller;

import com.umc.umcspring.ResponseMessage;
import com.umc.umcspring.StatusCode;
import com.umc.umcspring.dto.DefaultRes;
import com.umc.umcspring.dto.UserReqDTO;
import com.umc.umcspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<UserReqDTO> saveOrder(@RequestBody UserReqDTO userReqDTO) {
        HttpHeaders headers = new HttpHeaders();    // 요청에 대한 접속 운영체제, 브라우저, 인증정보와 같은 부가적인 정보
        headers.set("Users","Signup");    //header name, header value
        userService.insertUser(userReqDTO);
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.CREATE_USER, userReqDTO), HttpStatus.OK);
    }
}
