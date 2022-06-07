package com.swyg.petdiary.service.reply;


import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.domain.Reply;
import com.swyg.petdiary.dto.CommentDto;
import com.swyg.petdiary.dto.ReplyDto;
import com.swyg.petdiary.repository.ReplyRepository;
import com.swyg.petdiary.service.comment.CommentService;
import com.swyg.petdiary.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    @Autowired private final ReplyRepository replyRepository;
    @Autowired private final CommentService commentService;


    @Override
    public Reply findReply(Long replyId) throws Exception {
        return replyRepository.findById(replyId).orElseThrow(()->new Exception("not exists reply"));
    }

    /*덧글 작성 로직*/
    @Override
    @Transactional
    public Reply createReply(ReplyDto replyDto, Member member) throws Exception {
        Reply reply = new Reply();
        Comment comment = commentService.findComment(replyDto.getCommentId());
        reply.createComment(replyDto.getContent(), comment, member);
        return replyRepository.save(reply);
    }

    /*덧글 수정 로직*/
    @Override
    @Transactional
    public Reply updateReply(ReplyDto replyDto) throws Exception {
        Reply reply = findReply(replyDto.getReplyId());
        reply.updateComment(replyDto.getContent());
        return reply;
    }
    /*덧글 삭제 로직*/
    @Override
    @Transactional
    public Boolean deleteReply(ReplyDto replyDto) throws Exception {
        Reply reply = findReply(replyDto.getReplyId());
        replyRepository.delete(reply);
        return true;
    }

    @Override
    public List findByCommentId(Long commentId) {
        return replyRepository.findByCommentId(commentId);
    }
}
