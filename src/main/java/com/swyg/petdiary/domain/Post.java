package com.swyg.petdiary.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Post { //게시물 테이블과 매핑

    @Id
    @GeneratedValue
    private Long id;
    private String title; //제목
    private String body; //내용
    private String uploadTime; //작성일자 및 시간

    @OneToMany(mappedBy="post")
    private List<Comment> comments; //게시글에 작성된 댓글들

    @ManyToOne//FK
    @JoinColumn(name="board_id")
    private Board board; //게시글이 속한 게시판
    @ManyToOne//FK
    @JoinColumn(name="member_id")
    private Member member; //게시글을 작성한 회원
}
