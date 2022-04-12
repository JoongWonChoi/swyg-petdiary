package com.swyg.petdiary.domain;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Pet {

    @Id @GeneratedValue
    private Long id; //식별값
    private String name; //펫 이름
    private String type; //펫 종류
    private String birthDay; //펫 생일
    private String sex; //펫 성별

}
