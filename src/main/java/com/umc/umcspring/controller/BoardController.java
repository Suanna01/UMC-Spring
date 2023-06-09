package com.umc.umcspring.controller;

import com.umc.umcspring.ResponseMessage;
import com.umc.umcspring.StatusCode;
import com.umc.umcspring.dto.BoardReqDTO;
import com.umc.umcspring.dto.DefaultRes;
import com.umc.umcspring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
