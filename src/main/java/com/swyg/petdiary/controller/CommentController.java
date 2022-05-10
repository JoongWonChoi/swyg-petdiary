package com.swyg.petdiary.controller;

import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.dto.CommentDto;
import com.swyg.petdiary.service.comment.CommentService;
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

    /*댓글 작성*/
    @PostMapping("/comment/new")
    public Map createPost(@RequestBody CommentDto commentDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Comment comment;
        Map<String, Object> map = new HashMap<>();
        try{
            comment = commentService.createComment(commentDto, memberAdapter.getMember());
        }
        catch(Exception e){
            map.put("createSuccess", false);
            return map;
        }
        CommentDto commentAPI = new CommentDto();
        commentAPI.setCreateCommentAPI(comment.getContent(), comment.getMember().getName(), comment.getCreateTime());
        return commentAPI.getCreateCommentAPI();
    }
    /*댓글 수정*/
    @PostMapping("/comment/edit")
    public Map updatePost(@RequestBody CommentDto commentDto) {Comment comment;
        Map<String, Object> map = new HashMap<>();
        try{
            comment = commentService.updateComment(commentDto);
        }
        catch(Exception e){
            map.put("editSuccess", false);
            return map;
        }
        CommentDto commentAPI = new CommentDto();
        commentAPI.setUpdateCommentAPI(comment.getContent(), comment.getMember().getName(), comment.getCreateTime());
        return commentAPI.getUpdateCommentAPI();
    }
}
