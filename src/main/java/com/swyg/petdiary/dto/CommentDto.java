package com.swyg.petdiary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class CommentDto {

    private Long commentId;
    private Long postId; //댓글을 작성한 게시물 id
    private String content; // 댓글 내용
    private String createTime; // 댓글 작성 일자 및 시간

    private String writer;

    /*댓글 작성 API*/
    public void setCreateCommentAPI(String content, String writer, String createTime) {
        this.content = content;
        this.writer = writer;
        this.createTime = createTime;
    }
    public Map getCreateCommentAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("createSuccess", true);
        map.put("content", content);
        map.put("writer", writer);
        map.put("createTime", createTime);
        return map;
    }

    /*댓글 수정 API*/
    public void setUpdateCommentAPI(String content, String writer, String createTime) {
        this.content = content;
        this.writer = writer;
        this.createTime = createTime;
    }
    public Map getUpdateCommentAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("editSuccess", true);
        map.put("content", content);
        map.put("writer", writer);
        map.put("createTime", createTime);
        return map;
    }

}
