package com.swyg.petdiary.repository;


import com.swyg.petdiary.domain.Reply;
import com.swyg.petdiary.dto.CommentReplies.CommentReplies;
import com.swyg.petdiary.dto.postComments.PostComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query(value = "select r.id as replyId, m.name as name, r.content as content, r.create_time as createTime from reply r, member m where r.comment_id =:commentId",nativeQuery = true)
    List<CommentReplies> findByCommentId(Long commentId);
}
