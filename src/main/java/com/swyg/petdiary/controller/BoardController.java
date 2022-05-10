package com.swyg.petdiary.controller;


import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.domain.Board;
import com.swyg.petdiary.dto.BoardDto;
import com.swyg.petdiary.service.board.BoardService;
import com.swyg.petdiary.service.post.PostService;
import jdk.jshell.spi.ExecutionControlProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BoardController {
    @Autowired
    private final BoardService boardService;
    @Autowired
    private final PostService postService;


    /*게시판 생성*/
    @PostMapping("/board/new")
    public Map createBoard(@RequestBody BoardDto boardDto, @AuthenticationPrincipal MemberAdapter memberAdapter) throws Exception {
        Board board;
        try {
            board = boardService.create(boardDto, memberAdapter.getMember().getId());
        } catch (Exception e) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("boardCreate", false);
            return map;
        }
        BoardDto boardAPI = new BoardDto();
        boardAPI.setBoardCreateAPI(board.getBoardName());
        return boardAPI.getBoardCreateAPI();
    }

    /*게시판 수정*/
    @PostMapping("board/edit")
    public Map updateBoard(@RequestBody BoardDto boardDto) {
        Board board;
        try {
            board = boardService.update(boardDto);
        } catch (Exception e) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("boardEdit", false);
            return map;
        }
        BoardDto boardAPI = new BoardDto();
        boardAPI.setBoardUpdateAPI(board.getBoardName());
        return boardAPI.getBoardUpdateAPI();
    }

    /*나의 전체 게시판 보기*/
    @GetMapping("/boards")
    public List viewAllMyBoards(@AuthenticationPrincipal MemberAdapter memberAdapter) throws Exception {
        return boardService.viewAllBoards(memberAdapter.getMember());
    }

    /*게시판 내의 전체 게시물 조회*/
    @GetMapping("/board/{id}")
    public Object viewBoardPosts(@PathVariable("id") Long boardId) throws Exception {

        return postService.viewBoardPosts(boardId);
    }

}
