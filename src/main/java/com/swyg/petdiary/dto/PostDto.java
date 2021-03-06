package com.swyg.petdiary.dto;

import com.swyg.petdiary.domain.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PostDto {

    private Long postId;
    private String title; //제목
    private String body; //내용
    private String uploadTime; //작성일자 및 시간
    /*about board*/
    private String boardName;
    private String boardId;
    /*about member*/
    private String name;
    /*게시물당 댓글 수*/
    private int commentNum;

    private Post post;
    private List<Object> comments;


    //private List<Comment> comment;
    public Long getBoardId() {
        return Long.parseLong(boardId);
    }

    /*게시물 작성 API*/
    public void setCreatePostAPI(Long id, String title, String writer) {
        this.postId = id;
        this.title = title;
        this.name = writer;

    }
    public Map getCreatePostAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("createSuccess", true);
        map.put("id", postId);
        map.put("title", title);
        map.put("writer", name);
        return map;
    }

    /*게시물 조회 API*/
    public void setViewPostAPI(Long id, String title, String body, String uploadTime, String writer, String boardName, List comments) {
        this.postId = id;
        this.title = title;
        this.body = body;
        this.uploadTime = uploadTime;
        this.name = writer;
        this.boardName = boardName;
        this.comments = comments;
        //this.comment = comment;

    }
    public Map getViewPostAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", postId);
        map.put("title", title);
        map.put("body", body);
        map.put("uploadTime", uploadTime);
        map.put("writer", name);
        map.put("boardName", boardName);
        map.put("comments", comments);
        return map;
    }

    /*게시물 수정 API*/
}
