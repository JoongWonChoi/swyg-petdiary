package com.swyg.petdiary.domain;


import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Board { //게시판 테이블과 매핑

    @Id @GeneratedValue
    private Long id;
    private String name; //게시판 명

    @OneToMany
    private List<Post> posts; //게시판에 저장된 게시글들

    @ManyToOne //FK
    @JoinColumn(name="member_id")
    private Member member; //게시판을 생성한 회원 참조
}
