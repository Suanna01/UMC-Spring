package com.umc.umcspring.controller;

import com.umc.umcspring.ResponseMessage;
import com.umc.umcspring.StatusCode;
import com.umc.umcspring.domain.Board;
import com.umc.umcspring.dto.BoardReqDTO;
import com.umc.umcspring.dto.DefaultRes;
import com.umc.umcspring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    // 글 등록
    @PostMapping("/new")
    public ResponseEntity<BoardReqDTO> postBoard(@RequestBody BoardReqDTO boardReqDTO) {
        boardService.insertBoard(boardReqDTO);
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.CREATE_BOARD, boardReqDTO), HttpStatus.OK);
    }

    // 글 수정
    @PatchMapping("/edit/{boardId}")
    public ResponseEntity<BoardReqDTO> editBoard(@RequestBody BoardReqDTO boardReqDTO, @PathVariable ("boardId") String boardId) {
        boardService.updateBoard(boardReqDTO, boardId);
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.UPDATE_BOARD, boardReqDTO), HttpStatus.OK);
    }

    // 전체 글 조회
    @GetMapping("")
    public ResponseEntity<Board> getBoard(){
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.READ_BOARD, boardService.findAllBoard()), HttpStatus.OK);
    }
}