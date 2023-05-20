package com.umc.umcspring.repository;

import com.umc.umcspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email); // 이메일로 user 조회하기

    List<User> findAll(); // 전체 조회하기
}