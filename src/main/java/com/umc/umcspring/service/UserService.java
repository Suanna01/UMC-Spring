package com.umc.umcspring.service;

import com.umc.umcspring.domain.User;
import com.umc.umcspring.dto.UserPasswordReqDTO;
import com.umc.umcspring.dto.UserReqDTO;
import com.umc.umcspring.dto.UserWithdrawReqDTO;
import com.umc.umcspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입
    public String insertUser(UserReqDTO userReqDTO) {
        User user = new User();

        // PASSWORD를 USER에 저장
        user.setEmail(userReqDTO.getEmail());
        user.setName(userReqDTO.getName());
        user.setPassword(passwordEncoder.encode(userReqDTO.getPassword())); // 비밀번호 암호화

        // DB에 저장
        userRepository.save(user);

        return "회원가입 성공";
    }

    // 회원조회
    public List<User> selectAllUser() {
        return userRepository.findAll();
    }

    // 회원정보 변경
    public String changeUser(UserPasswordReqDTO userPasswordReqDto) {
        User user = userRepository.findByEmail(userPasswordReqDto.getEmail());

        user.setPassword(passwordEncoder.encode(userPasswordReqDto.getNewPassword()));

        userRepository.save(user);

        return "회원정보 변경";
    }

    // 회원 탈퇴
    public String deleteUser(UserWithdrawReqDTO userWithdrawReqDTO) {
        User user = userRepository.findByEmail(userWithdrawReqDTO.getEmail());
        userRepository.delete(user);
        return "회원탈퇴";
    }
}
