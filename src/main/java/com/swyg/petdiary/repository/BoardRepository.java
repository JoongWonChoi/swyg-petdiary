package com.swyg.petdiary.repository;

import com.swyg.petdiary.domain.Board;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.viewAllBoards.ViewAllBoardInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByMemberId(Long memberId);

    @Query("select b.id as id, b.boardName as boardName from Board b where b.member = :member")
    List<ViewAllBoardInterface> findBoardsByMemberId(@Param("member") Member member);

}
