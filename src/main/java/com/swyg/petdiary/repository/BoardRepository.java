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

    @Query(value = "select b.id as id, b.boardName as boardName from board b where b.member_id = :memberId", nativeQuery = true)
    List<ViewAllBoardInterface> findBoardsByMemberId(@Param("memberId") Long memberId);

}
