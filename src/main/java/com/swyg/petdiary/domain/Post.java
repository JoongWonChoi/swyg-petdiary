package com.swyg.petdiary.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @JsonBackReference
    @JoinColumn(name="board_id")
    private Board board; //게시글이 속한 게시판

    @ManyToOne//FK
    @JoinColumn(name="member_id")
    private Member member; //게시글을 작성한 회원

    /*연관관계 메서드*/
    //Post는 FK로 Board와 Member를 참조한다. 따라서 Post 객체가 하나 생성될 때 마다 Board와 Member에 연관관계를 주입해주어야한다.
    //연관관계 메서드에 의해 Board와 Member 엔티티에는 Post를 List 형태로 보관하게 된다.
    public void addPostinMember(Member member) { //생성된 게시물이 참조할 Member 객체
        this.member = member;
        member.getPosts().add(this);
    }

    public void addPostinBoard(Board board) {//생성된 게시물이 참조할 Board 객체
        this.board = board;
        board.getPosts().add(this);
    }

    /*게시물 생성*/
    public void createPost(String title, String body, Board board, Member member) {
        this.title = title;
        this.body = body;
        this.board = board;
        this.member = member;
        //작성시간
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = new Date();
        this.uploadTime = simpleDateFormat.format(dateTime);
    }

    /*게시물 수정*/
    public void updatePost(String title, String body) {
        this.title = title;
        this.body = body;
        //수정시간
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = new Date();
        this.uploadTime = simpleDateFormat.format(dateTime);

    }
}
