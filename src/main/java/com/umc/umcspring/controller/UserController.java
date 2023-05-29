package com.umc.umcspring.controller;

import com.umc.umcspring.ResponseMessage;
import com.umc.umcspring.StatusCode;
import com.umc.umcspring.domain.User;
import com.umc.umcspring.dto.DefaultRes;
import com.umc.umcspring.dto.UserPasswordReqDTO;
import com.umc.umcspring.dto.UserReqDTO;
import com.umc.umcspring.dto.UserWithdrawReqDTO;
import com.umc.umcspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<UserReqDTO> saveOrder(@RequestBody UserReqDTO userReqDTO) {
        userService.insertUser(userReqDTO);
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.CREATE_USER, userReqDTO), HttpStatus.OK);
    }

    // 회원 정보 조회
    @GetMapping("/list")
    public ResponseEntity<User> findAll() {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userService.selectAllUser()), HttpStatus.OK);
    }

    // 회원 정보 수정
    @PatchMapping("/profile-modify")
    public ResponseEntity<UserReqDTO> changePassword(@RequestBody UserPasswordReqDTO userReqDTO) {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.UPDATE_USER, userService.changeUser(userReqDTO)), HttpStatus.OK);
    }

    // 회원 탈퇴
    @DeleteMapping("/withdraw")
    public ResponseEntity<UserWithdrawReqDTO> withdrawUser(@RequestBody UserWithdrawReqDTO userWithdrawReqDTO) {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.DELETE_USER, userService.deleteUser(userWithdrawReqDTO)), HttpStatus.OK);
    }

    // 프로필 조회
    @GetMapping("/profile/{email}")
    public ResponseEntity<User> profile(@PathVariable ("email") String email) {
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER_PROFILE, userService.getUserProfile(email)), HttpStatus.OK);
    }

}
