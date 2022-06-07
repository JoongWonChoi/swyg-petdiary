package com.swyg.petdiary.service.comment;

import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.CommentDto;
import com.swyg.petdiary.dto.postComments.PostComments;
import com.swyg.petdiary.repository.CommentRepository;
import com.swyg.petdiary.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements  CommentService{

    @Autowired private final CommentRepository commentRepository;
    @Autowired private final PostService postService;

    @Override
    public Comment findComment(Long commentId) throws Exception {
        return commentRepository.findById(commentId).orElseThrow(() -> new Exception("not exists comment"));
    }

    @Override
    public List<PostComments> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    @Transactional
    public Comment createComment(CommentDto commentDto, Member member) throws Exception {
        Comment comment = new Comment();
        comment.createComment(commentDto.getContent(), postService.findPost(commentDto.getPostId()), member);
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public Comment updateComment(CommentDto commentDto) throws Exception {
        Comment comment = findComment(commentDto.getCommentId());
        comment.updateComment(commentDto.getContent());
        return comment;
    }

    @Override
    @Transactional
    public Boolean deleteComment(CommentDto commentDto) throws Exception {
        Comment comment;
        try{
            comment = findComment(commentDto.getCommentId());
        }
        catch(Exception e){
            return false;
        }
        commentRepository.delete(comment);
        return true;
    }
}
