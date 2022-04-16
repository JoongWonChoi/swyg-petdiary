package com.swyg.petdiary.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment { //댓글 테이블과 매핑

    @Id
    @GeneratedValue
    private Long id;
    private String title; // 댓글 제목
    private String content; // 댓글 내용
    private String createDate; // 댓글 작성 일자 및 시간

    @ManyToOne//FK
    @JoinColumn(name="post_id")
    private Post post; //댓글이 쓰여진 게시물 참조
    @ManyToOne//FK
    @JoinColumn(name="member_id")
    private Member member; //댓글을 쓴 회원 참조
}
