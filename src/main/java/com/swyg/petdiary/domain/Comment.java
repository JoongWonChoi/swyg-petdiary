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
public class Comment { //댓글 테이블과 매핑

    @Id
    @GeneratedValue
    private Long id;
    private String content; // 댓글 내용
    private String createTime; // 댓글 작성 일자 및 시간

    @ManyToOne//FK
    @JsonBackReference
    @JoinColumn(name="post_id")
    private Post post; //댓글이 쓰여진 게시물 참조
    @ManyToOne//FK
    @JoinColumn(name="member_id")
    private Member member; //댓글을 쓴 회원 참조

    @OneToMany(mappedBy = "member") //Reply Entity의 'member(FK)' 필드에 의해 참조됨
    private List<Reply> replies;

    /*연관관계 메서드*/
    public void addCommentInMember(Member member) {
        this.member = member;
        member.getComments().add(this);
    }

    public void addCommentInPost(Post post) {
        this.post = post;
        post.getComments().add(this);

    }

    /*댓글 생성 로직*/
    public void createComment(String content, Post post, Member member) {
        this.content = content;
        this.post = post;
        this.member = member;
        //작성시간
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = new Date();
        this.createTime = simpleDateFormat.format(dateTime);

    }
    /*댓글 수정 로직*/
    public void updateComment(String content) {
        this.content = content;
        //수정시간
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = new Date();
        this.createTime = simpleDateFormat.format(dateTime);

    }
}
