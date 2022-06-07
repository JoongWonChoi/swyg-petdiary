package com.swyg.petdiary.repository;

import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.dto.postComments.PostComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select c.id as commentId, m.name as name, c.content as content, c.create_time as createTime from Comment c, Member m where c.post_id =:postId",nativeQuery = true)
    List<PostComments> findByPostId(Long postId);
}
