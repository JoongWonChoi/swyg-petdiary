package com.swyg.petdiary.controller;

import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.domain.Reply;
import com.swyg.petdiary.dto.CommentDto;
import com.swyg.petdiary.dto.ReplyDto;
import com.swyg.petdiary.service.comment.CommentService;
import com.swyg.petdiary.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CommentController {
    @Autowired
    private final CommentService commentService;
    @Autowired
    private final ReplyService replyService;

    /*===댓글 controller===*/
    /*댓글 작성*/
    @PostMapping("/comment/new")
    public Map createPost(@RequestBody CommentDto commentDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Comment comment;
        Map<String, Object> map = new HashMap<>();
        try {
            comment = commentService.createComment(commentDto, memberAdapter.getMember());
        } catch (Exception e) {
            map.put("createSuccess", false);
            return map;
        }
        CommentDto commentAPI = new CommentDto();
        commentAPI.setCreateCommentAPI(comment.getContent(), comment.getMember().getName(), comment.getCreateTime());
        return commentAPI.getCreateCommentAPI();
    }

    /*댓글 수정*/
    @PostMapping("/comment/edit")
    public Map updatePost(@RequestBody CommentDto commentDto) {
        Comment comment;
        Map<String, Object> map = new HashMap<>();
        try {
            comment = commentService.updateComment(commentDto);
        } catch (Exception e) {
            map.put("editSuccess", false);
            return map;
        }
        CommentDto commentAPI = new CommentDto();
        commentAPI.setUpdateCommentAPI(comment.getContent(), comment.getMember().getName(), comment.getCreateTime());
        return commentAPI.getUpdateCommentAPI();
    }
    /*댓글 삭제*/
    @PostMapping("/comment/delete")
    public Map deleteComment(@RequestBody CommentDto commentDto) {
        boolean b;
        Map<String, Object> map = new HashMap<>();
        try {
            b = commentService.deleteComment(commentDto);
        } catch (Exception e) {
            map.put("deleteSuccess", false);
            return map;
        }
        map.put("deleteSuccess", true);
        return map;
    }

    /*===덧글 controller ===*/
    /*덧글 작성*/
    @PostMapping("/reply/new")
    public Map createReply(@RequestBody ReplyDto replyDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Reply reply;
        Map<String, Object> map = new HashMap<>();
        try {
            reply = replyService.createReply(replyDto, memberAdapter.getMember());
        } catch (Exception e) {
            map.put("createSuccess", false);
            return map;
        }
        map.put("success", true);
        return map;

    }

    /*덧글 수정*/
    @PostMapping("/reply/edit")
    public Map updateReply(@RequestBody ReplyDto replyDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Reply reply;
        Map<String, Object> map = new HashMap<>();
        try {
            reply = replyService.updateReply(replyDto);
        } catch (Exception e) {
            map.put("updateSuccess", false);
            return map;
        }
        map.put("updateSuccess", true);
        return map;
    }

    /*덧글 삭제*/
    @PostMapping("/reply/delete")
    public Map deleteReply(@RequestBody ReplyDto replyDto) {
        boolean b;
        Map<String, Object> map = new HashMap<>();
        try {
            b = replyService.deleteReply(replyDto);
        } catch (Exception e) {
            map.put("deleteSuccess", false);
            return map;
        }
        map.put("deleteSuccess", true);
        return map;
    }
}
