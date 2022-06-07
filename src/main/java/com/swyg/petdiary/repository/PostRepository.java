package com.swyg.petdiary.repository;

import com.swyg.petdiary.domain.Board;
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

    /*@Query(value = "select p.id as id, p.title as title, p.body as body, p.upload_time as uploadTime, count(*) as commentNum from Post p, Comment c where p.board_id = :boardId group by p.id, c.post_id having p.id=c.post_id", nativeQuery = true)
    List<ViewAllPostInterface> findByBoard(@Param("boardId") Long boardId);*/

    @Query(value = "select p.id as id, p.title as title, p.body as body, p.upload_time as uploadTime, count(c.id) as commentNum from Post p, Comment c where p.board_id = :boardId group by p.id", nativeQuery = true)
    List<ViewAllPostInterface> findByBoard(@Param("boardId") Long boardId);

    @Query(value = "select p.id as id, p.title as title, p.body as body, p.upload_time as uploadTime from Post p", nativeQuery = true)
    List<ViewAllPostInterface> findAllPosts();


}
