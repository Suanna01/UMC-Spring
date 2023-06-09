package com.umc.umcspring.repository;

import com.umc.umcspring.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAll(); // 전체 조회하기

}
