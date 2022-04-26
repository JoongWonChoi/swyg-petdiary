package com.swyg.petdiary.dto;

import com.swyg.petdiary.domain.Board;
import com.swyg.petdiary.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class PostDto {

    private Long id;
    private String title; //제목
    private String body; //내용
    private String uploadTime; //작성일자 및 시간
    private Member member;
    private Board board;
    //private List<Comment> comment;

    /*게시물 작성 API*/
    public void setCreatePostAPI(Long id, String title) {
        this.id = id;
        this.title = title;

    }
    public Map getCreatePostAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("createSuccess", true);
        map.put("id", id);
        map.put("title", title);
        return map;
    }

    /*게시물 조회 API*/
    public void setViewPostAPI(Long id, String title, String body, String uploadTime, Member member, Board board) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.uploadTime = uploadTime;
        this. member = member;
        this.board = board;
        //this.comment = comment;

    }
    public Map getViewPostAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("title", title);
        map.put("body", body);
        map.put("uploadTime", uploadTime);
        map.put("writer", member.getName());
        map.put("board", board.getBoardName());
        return map;
    }

    /*게시물 수정 API*/
}
