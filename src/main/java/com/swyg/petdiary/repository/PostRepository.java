package com.swyg.petdiary.repository;

import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.domain.Post;
import com.swyg.petdiary.dto.viewAllPosts.ViewAllPostInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select p.id as id, p.title as title, p.body as body, p.upload_time as uploadTime from Post p where p.board_id = :boardId",nativeQuery = true)
    Optional<List<ViewAllPostInterface>> findByBoardId(@Param("boardId") Long boardId);
}
