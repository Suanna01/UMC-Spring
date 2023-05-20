package com.umc.umcspring.controller;

import com.umc.umcspring.domain.User;
import com.umc.umcspring.dto.UserReqDTO;
import com.umc.umcspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    // 회원가입
    @PostMapping(value = "/signup")
    public String saveOrder(@RequestBody UserReqDTO userReqDTO) {
        System.out.println(userReqDTO.getEmail());
        userService.insertUser(userReqDTO);
        return "signup";
    }
}
