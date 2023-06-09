package com.umc.umcspring.service;

import com.umc.umcspring.domain.Board;
import com.umc.umcspring.dto.BoardReqDTO;
import com.umc.umcspring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 글 등록
    public String insertBoard(BoardReqDTO boardReqDTO) {
        Board board = new Board();

        board.setTitle(boardReqDTO.getTitle());
        board.setContent(boardReqDTO.getContent());

        boardRepository.save(board);

        return "글 등록 성공";
    }
}
