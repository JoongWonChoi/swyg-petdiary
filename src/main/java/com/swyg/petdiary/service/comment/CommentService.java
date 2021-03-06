package com.swyg.petdiary.service.comment;

import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.CommentDto;
import com.swyg.petdiary.dto.postComments.PostComments;

import java.util.List;

public interface CommentService {

    Comment findComment(Long commentId) throws Exception;
    List<PostComments> findByPostId(Long postId);
    Comment createComment(CommentDto commentDto, Member member) throws Exception;
    Comment updateComment(CommentDto commentDto) throws Exception;
    Boolean deleteComment(CommentDto commentDto) throws Exception;
}
