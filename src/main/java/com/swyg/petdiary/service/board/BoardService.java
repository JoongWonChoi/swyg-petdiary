package com.swyg.petdiary.service.board;

import com.swyg.petdiary.domain.Board;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.BoardDto;
import com.swyg.petdiary.dto.viewAllBoards.ViewAllBoardInterface;

import java.util.List;

public interface BoardService {
    Board findById(Long boardId) throws Exception;
    Board create(BoardDto boardDto, Long memberId) throws Exception;
    Board update(BoardDto boardDto) throws Exception;
    List<ViewAllBoardInterface> viewAllBoards(Member member) throws Exception;
    boolean deleteBoard(BoardDto boardDto) throws Exception;

}
