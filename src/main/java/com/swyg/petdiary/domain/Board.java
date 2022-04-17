package com.swyg.petdiary.domain;
import lombok.Getter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Board { //게시판 테이블과 매핑
    @Id @GeneratedValue
    private Long id;
    private String boardName; //게시판 명

    @OneToMany(mappedBy="board")
    private List<Post> posts; //게시판에 저장된 게시글들

    @ManyToOne //FK
    @JoinColumn(name="member_id")
    private Member member; //게시판을 생성한 회원 참조

    /*연관관계 메서드*/
    public void addBoardInMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }

    /*게시물 생성 로직*/
    public void createBoard(String boardName, Member member) {
        this.boardName = boardName;
        this.member = member;
    }
    /*게시물 수정 로직*/
    public void updateBoard(String boardName) {
        this.boardName = boardName;
    }
}
