package com.swyg.petdiary.domain;

import lombok.Getter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
public class Reply {
    @Id @GeneratedValue
    private Long id;
    private String content;
    private String createTime;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member; //덧글을 쓴 회원 참조, 하나의 회원은 여러개의 덧글을 쓸 수 있고, 하나의 덧글은 한명의 회원이 작성 가능
    @ManyToOne
    @JoinColumn(name="comment_id")
    private Comment comment; //덧글이 생성된 댓글 참조, 하나의 댓글엔 여러개의 덧글이 달리고 하나의 덧글은 하나의 댓글에 달림

    /*연관관계 메서드*/
    public void addReplyInMember(Member member) {
        this.member = member;
        member.getReplies().add(this);
    }
    public void addReplyInComment(Member member) {
        this.member = member;
        member.getReplies().add(this);
    }

    /*덧글 생성 로직*/
    public void createComment(String content, Comment comment, Member member) {
        this.content = content;
        this.comment = comment;
        this.member = member;
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
