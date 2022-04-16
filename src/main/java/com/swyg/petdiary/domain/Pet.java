package com.swyg.petdiary.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Pet { //반려동물 테이블과 매핑

    @Id @GeneratedValue
    private Long id; //식별값
    private String name; //펫 이름
    private String type; //펫 종류
    private String typeDetail; //펫 품종
    private String birthDay; //펫 생일
    private String sex; //펫 성별

    @ManyToOne //FK
    @JoinColumn(name="member_id")
    private Member member; //반려동물의 주인(참조)

    /*연관관계 메서드*/
    public void addPetinMember(Member member) {
        this.member = member;
        member.getPets().add(this);
    }

    /*반려동물 생성 로직*/
    public void registerPet(String name, String type, String typeDetail, String birthDay, String sex, Member member) {
        this.name = name;
        this.type = type;
        this.typeDetail = typeDetail;
        this.birthDay = birthDay;
        this.sex = sex;
        this.member = member;
    }
    /*반려동물 수정 로직*/
    public void updatePet(String name, String type, String typeDetail, String birthDay, String sex) {
        this.name = name;
        this.type = type;
        this.typeDetail = typeDetail;
        this.birthDay = birthDay;
        this.sex = sex;
    }
}
