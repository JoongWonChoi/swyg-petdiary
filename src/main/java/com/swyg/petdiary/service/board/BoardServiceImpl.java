package com.swyg.petdiary.service.board;

import com.swyg.petdiary.domain.Board;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.BoardDto;
import com.swyg.petdiary.dto.viewAllBoards.ViewAllBoardInterface;
import com.swyg.petdiary.repository.BoardRepository;
import com.swyg.petdiary.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{

    @Autowired private final BoardRepository boardRepository;
    @Autowired private final MemberService memberService;

    @Override
    public Board findById(Long boardId) throws Exception {
        return boardRepository.findById(boardId).orElseThrow(()->new Exception("not exists Board"));
    }
    @Transactional
    @Override
    public Board create(BoardDto boardDto, Long memberId) throws Exception {
        Member member = memberService.findById(memberId);
        Board board = new Board();
        board.createBoard(boardDto.getBoardName(), member);
        return boardRepository.save(board);
    }
    @Transactional
    @Override
    public Board update(BoardDto boardDto) throws Exception {
        Board board = findById(boardDto.getBoardId());
        board.updateBoard(boardDto.getBoardName());
        return board;
    }

    @Override
    public List<ViewAllBoardInterface> viewAllBoards(Member member) throws Exception {
        //Member member = memberService.findById(memberId);
        return boardRepository.findBoardsByMemberId(member.getId());
    }

    @Override
    @Transactional
    public boolean deleteBoard(BoardDto boardDto) throws Exception {
        Board board = findById(boardDto.getBoardId());
        boardRepository.delete(board);
        return false;
    }

}
