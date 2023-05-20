package com.umc.umcspring.service;

import com.umc.umcspring.domain.User;
import com.umc.umcspring.dto.DefalutResDTO;
import com.umc.umcspring.dto.UserReqDTO;
import com.umc.umcspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입
    public DefalutResDTO inserUser(UserReqDTO userReqDTO) {
        User user = new User();

        // PASSWORD를 USER에 저장
        user.setEmail(userReqDTO.getEmail());
        user.setName(userReqDTO.getName());
        user.setPassword(passwordEncoder.encode(userReqDTO.getPassword())); // 비밀번호 암호화

        // DB에 저장
        userRepository.save(user);

        return DefalutResDTO.of("SUCCESS", "회원가입 성공", user);
    }
}
