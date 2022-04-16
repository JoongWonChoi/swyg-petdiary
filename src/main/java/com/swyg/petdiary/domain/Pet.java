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
    private String birthDay; //펫 생일
    private String sex; //펫 성별

    @ManyToOne //FK
    @JoinColumn(name="member_id")
    private Member member; //반려동물의 주인(참조)

    public void registerPet(String name, String type, String birthDay, String sex) {
        this.name = name;
        this.type = type;
        this.birthDay = birthDay;
        this.sex = sex;
    }
}
